package js.parser;

import common.ListenerUtils;
import common.NodeKeeper;
import common.ParserWrapper;
import org.antlr.v4.runtime.*;

public final class JSWrapper implements ParserWrapper {

    private CommonTokenStream tokenStream;
    private ECMAScriptParser parser;

    public ECMAScriptParser getParser() {
        return this.parser;
    }

    public ParserRuleContext getContext() {
        return this.parser.program();
    }

    public TokenStreamRewriter getRewriter() {
        return new TokenStreamRewriter(this.tokenStream);
    }

    @Override
    public void init(CharStream input) {
        Lexer lexer = new ECMAScriptLexer(input);
        ListenerUtils.withDefaultListener(lexer);

        this.tokenStream = new CommonTokenStream(lexer);

        this.parser = new ECMAScriptParser(this.tokenStream);
        ListenerUtils.withDefaultListener(this.parser);
    }

    public NodeKeeper collect(ParserRuleContext context) {
        JSCollector collector = new JSCollector();
        collector.visit(context);
        return new NodeKeeper(collector.getMap());
    }

    public JSWrapper() {
    }

    public JSWrapper(CharStream input) {
        init(input);
    }

    JSWrapper(ECMAScriptLexer lexer) {
        this.tokenStream = new CommonTokenStream(lexer);
        this.parser = new ECMAScriptParser(this.tokenStream);
        ListenerUtils.withDefaultListener(this.parser);
    }

    public JSWrapper withErrorListener(ANTLRErrorListener listener) {
        ListenerUtils.withListener(this.parser, listener);
        return this;
    }
}
package js.parser;

import common.ListenerUtils;
import common.NodeKeeper;
import common.FotParser;
import org.antlr.v4.runtime.*;

public final class JSFotParser implements FotParser {

    private CommonTokenStream tokenStream;
    private ECMAScriptParser parser;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public ECMAScriptParser getParser() {
        return this.parser;
    }

    public ParserRuleContext getParseRuleContext() {
        return this.parser.program();
    }

    public TokenStreamRewriter getRewriter() {
        return new TokenStreamRewriter(this.tokenStream);
    }

    @Override
    public void init(CharStream charStream) {
        Lexer lexer = new ECMAScriptLexer(charStream);
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

    public JSFotParser() {
    }

    public JSFotParser(CharStream charStream) {
        init(charStream);
    }

    JSFotParser(ECMAScriptLexer lexer) {
        this.tokenStream = new CommonTokenStream(lexer);
        this.parser = new ECMAScriptParser(this.tokenStream);
        ListenerUtils.withDefaultListener(this.parser);
    }

    public JSFotParser withErrorListener(ANTLRErrorListener listener) {
        ListenerUtils.withListener(this.parser, listener);
        return this;
    }
}

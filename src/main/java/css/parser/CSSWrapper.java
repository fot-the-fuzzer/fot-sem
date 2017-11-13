package css.parser;

import common.ListenerUtils;
import common.NodeKeeper;
import common.ParserWrapper;
import org.antlr.v4.runtime.*;

public class CSSWrapper implements ParserWrapper {

    private CommonTokenStream tokenStream;
    private CSS3Parser parser;

    @Override
    public ParserRuleContext getContext() {
        return this.parser.stylesheet();
    }

    @Override
    public TokenStreamRewriter getRewriter() {
        return new TokenStreamRewriter(this.tokenStream);
    }

    public CSSWrapper() {
    }

    @Override
    public void init(CharStream charStream) {
        Lexer lexer = new CSS3Lexer(charStream);
        ListenerUtils.withDefaultListener(lexer);

        this.tokenStream = new CommonTokenStream(lexer);

        this.parser = new CSS3Parser(this.tokenStream);
        ListenerUtils.withDefaultListener(this.parser);
    }

    @Override
    public NodeKeeper collect(ParserRuleContext context) {
        CSSCollector collector = new CSSCollector();
        collector.visit(context);
        return new NodeKeeper(collector.getMap());
    }
}

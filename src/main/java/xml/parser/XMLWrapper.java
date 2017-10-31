package xml.parser;

import common.ListenerUtils;
import common.NodeKeeper;
import common.ParserWrapper;
import org.antlr.v4.runtime.*;

public class XMLWrapper implements ParserWrapper {

    private CommonTokenStream tokenStream;
    private XMLParser parser;

    @Override
    public ParserRuleContext getContext() {
        return this.parser.document();
    }

    @Override
    public TokenStreamRewriter getRewriter() {
        return new TokenStreamRewriter(this.tokenStream);
    }

    public XMLWrapper() {

    }

    @Override
    public void init(CharStream charStream) {
        Lexer lexer = new XMLLexer(charStream);
        ListenerUtils.withDefaultListener(lexer);

        this.tokenStream = new CommonTokenStream(lexer);

        this.parser = new XMLParser(this.tokenStream);
        ListenerUtils.withDefaultListener(this.parser);
    }

    public NodeKeeper collect(ParserRuleContext context) {
        XMLCollector collector = new XMLCollector();
        collector.visit(context);
        return new NodeKeeper(collector.getMap());
    }

}

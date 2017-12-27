package xml.parser;

import common.ListenerUtils;
import common.NodeKeeper;
import common.FotParser;
import org.antlr.v4.runtime.*;

public class XMLFotParser implements FotParser {

    private CommonTokenStream tokenStream;
    private XMLParser parser;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public ParserRuleContext getParseRuleContext() {
        return this.parser.document();
    }

    @Override
    public TokenStreamRewriter getRewriter() {
        return new TokenStreamRewriter(this.tokenStream);
    }

    public XMLFotParser() {
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

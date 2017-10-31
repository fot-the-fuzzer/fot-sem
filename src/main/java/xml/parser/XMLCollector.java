package xml.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.HashMap;
import java.util.Map;

public class XMLCollector extends XMLParserBaseVisitor {

    private Map<Interval, String> map = new HashMap<>();

    public Map<Interval, String> getMap() {
        return this.map;
    }

    @Override
    public Object visitDocument(XMLParser.DocumentContext ctx) {
        ignore(ctx);
        return super.visitDocument(ctx);
    }

    @Override
    public Object visitProlog(XMLParser.PrologContext ctx) {
        insert(ctx);
        return super.visitProlog(ctx);
    }

    @Override
    public Object visitContent(XMLParser.ContentContext ctx) {
        insert(ctx);
        return super.visitContent(ctx);
    }

    @Override
    public Object visitElement(XMLParser.ElementContext ctx) {
        insert(ctx);
        return super.visitElement(ctx);
    }

    @Override
    public Object visitReference(XMLParser.ReferenceContext ctx) {
        insert(ctx);
        return super.visitReference(ctx);
    }

    @Override
    public Object visitAttribute(XMLParser.AttributeContext ctx) {
        insert(ctx);
        return super.visitAttribute(ctx);
    }

    @Override
    public Object visitChardata(XMLParser.ChardataContext ctx) {
        insert(ctx);
        return super.visitChardata(ctx);
    }

    @Override
    public Object visitMisc(XMLParser.MiscContext ctx) {
        insert(ctx);
        return super.visitMisc(ctx);
    }

    /**
     * inner strategies should be defined differently, so DON'T make it a general method
      */
    @SuppressWarnings("Duplicates")
    private void insert(ParserRuleContext ctx) {
        Interval interval = ctx.getSourceInterval();
        // for text
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval textInterval = new Interval(a, b);
        CharStream input = ctx.start.getInputStream();
        String text = input.getText(textInterval);
        this.map.put(interval, text);
    }

    private void ignore(ParserRuleContext ctx) {
        // no-op
    }
}

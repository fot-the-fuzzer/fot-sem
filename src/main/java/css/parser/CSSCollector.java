package css.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.HashMap;
import java.util.Map;

public class CSSCollector extends CSS3BaseVisitor {

    private Map<Interval, String> map = new HashMap<>();

    public Map<Interval, String> getMap() {
        return this.map;
    }

    @SuppressWarnings("Duplicates")
    private void insert(ParserRuleContext ctx) {
        Interval interval = ctx.getSourceInterval();
        // for text
        int a = ctx.start.getStartIndex();
        // FIXME stop may be null
        int b = ctx.stop.getStopIndex();
        Interval textInterval = new Interval(a, b);
        CharStream input = ctx.start.getInputStream();
        String text = input.getText(textInterval);
        this.map.put(interval, text);
    }

    private void ignore(ParserRuleContext ctx) {
        // no-op
    }

    /////////////////////////////////////////////////////////////////

    @Override
    public Object visitStylesheet(CSS3Parser.StylesheetContext ctx) {
        ignore(ctx);
        return super.visitStylesheet(ctx);
    }

    @Override
    public Object visitGoodCharset(CSS3Parser.GoodCharsetContext ctx) {
        insert(ctx);
        return super.visitGoodCharset(ctx);
    }

    @Override
    public Object visitBadCharset(CSS3Parser.BadCharsetContext ctx) {
        insert(ctx);
        return super.visitBadCharset(ctx);
    }

    @Override
    public Object visitGoodImport(CSS3Parser.GoodImportContext ctx) {
        insert(ctx);
        return super.visitGoodImport(ctx);
    }

    @Override
    public Object visitBadImport(CSS3Parser.BadImportContext ctx) {
        insert(ctx);
        return super.visitBadImport(ctx);
    }

    @Override
    public Object visitGoodNamespace(CSS3Parser.GoodNamespaceContext ctx) {
        insert(ctx);
        return super.visitGoodNamespace(ctx);
    }

    @Override
    public Object visitBadNamespace(CSS3Parser.BadNamespaceContext ctx) {
        insert(ctx);
        return super.visitBadNamespace(ctx);
    }

    @Override
    public Object visitNamespacePrefix(CSS3Parser.NamespacePrefixContext ctx) {
        insert(ctx);
        return super.visitNamespacePrefix(ctx);
    }

    @Override
    public Object visitMedia(CSS3Parser.MediaContext ctx) {
        insert(ctx);
        return super.visitMedia(ctx);
    }

    @Override
    public Object visitMediaQueryList(CSS3Parser.MediaQueryListContext ctx) {
        insert(ctx);
        return super.visitMediaQueryList(ctx);
    }

    @Override
    public Object visitMediaQuery(CSS3Parser.MediaQueryContext ctx) {
        insert(ctx);
        return super.visitMediaQuery(ctx);
    }

    @Override
    public Object visitMediaType(CSS3Parser.MediaTypeContext ctx) {
        ignore(ctx);
        return super.visitMediaType(ctx);
    }

    @Override
    public Object visitMediaExpression(CSS3Parser.MediaExpressionContext ctx) {
        insert(ctx);
        return super.visitMediaExpression(ctx);
    }

    @Override
    public Object visitMediaFeature(CSS3Parser.MediaFeatureContext ctx) {
        insert(ctx);
        return super.visitMediaFeature(ctx);
    }

    @Override
    public Object visitPage(CSS3Parser.PageContext ctx) {
        insert(ctx);
        return super.visitPage(ctx);
    }

    @Override
    public Object visitPseudoPage(CSS3Parser.PseudoPageContext ctx) {
        insert(ctx);
        return super.visitPseudoPage(ctx);
    }

    @Override
    public Object visitSelectorGroup(CSS3Parser.SelectorGroupContext ctx) {
        insert(ctx);
        return super.visitSelectorGroup(ctx);
    }

    @Override
    public Object visitSelector(CSS3Parser.SelectorContext ctx) {
        insert(ctx);
        return super.visitSelector(ctx);
    }

    @Override
    public Object visitCombinator(CSS3Parser.CombinatorContext ctx) {
        insert(ctx);
        return super.visitCombinator(ctx);
    }

    @Override
    public Object visitSimpleSelectorSequence(CSS3Parser.SimpleSelectorSequenceContext ctx) {
        insert(ctx);
        return super.visitSimpleSelectorSequence(ctx);
    }

    @Override
    public Object visitTypeSelector(CSS3Parser.TypeSelectorContext ctx) {
        insert(ctx);
        return super.visitTypeSelector(ctx);
    }

    // ignore
    @Override
    public Object visitTypeNamespacePrefix(CSS3Parser.TypeNamespacePrefixContext ctx) {
        ignore(ctx);
        return super.visitTypeNamespacePrefix(ctx);
    }

    @Override
    public Object visitElementName(CSS3Parser.ElementNameContext ctx) {
        ignore(ctx);
        return super.visitElementName(ctx);
    }

    @Override
    public Object visitUniversal(CSS3Parser.UniversalContext ctx) {
        insert(ctx);
        return super.visitUniversal(ctx);
    }

    @Override
    public Object visitClassName(CSS3Parser.ClassNameContext ctx) {
        insert(ctx);
        return super.visitClassName(ctx);
    }

    @Override
    public Object visitAttrib(CSS3Parser.AttribContext ctx) {
        insert(ctx);
        return super.visitAttrib(ctx);
    }

    @Override
    public Object visitPseudo(CSS3Parser.PseudoContext ctx) {
        insert(ctx);
        return super.visitPseudo(ctx);
    }

    @Override
    public Object visitFunctionalPseudo(CSS3Parser.FunctionalPseudoContext ctx) {
        insert(ctx);
        return super.visitFunctionalPseudo(ctx);
    }

    @Override
    public Object visitExpression(CSS3Parser.ExpressionContext ctx) {
        insert(ctx);
        return super.visitExpression(ctx);
    }

    @Override
    public Object visitNegation(CSS3Parser.NegationContext ctx) {
        insert(ctx);
        return super.visitNegation(ctx);
    }

    @Override
    public Object visitNegationArg(CSS3Parser.NegationArgContext ctx) {
        insert(ctx);
        return super.visitNegationArg(ctx);
    }

    @Override
    public Object visitGoodOperator(CSS3Parser.GoodOperatorContext ctx) {
        insert(ctx);
        return super.visitGoodOperator(ctx);
    }

    @Override
    public Object visitBadOperator(CSS3Parser.BadOperatorContext ctx) {
        insert(ctx);
        return super.visitBadOperator(ctx);
    }

    @Override
    public Object visitGoodProperty(CSS3Parser.GoodPropertyContext ctx) {
        insert(ctx);
        return super.visitGoodProperty(ctx);
    }

    @Override
    public Object visitBadProperty(CSS3Parser.BadPropertyContext ctx) {
        insert(ctx);
        return super.visitBadProperty(ctx);
    }

    @Override
    public Object visitKnownRuleset(CSS3Parser.KnownRulesetContext ctx) {
        insert(ctx);
        return super.visitKnownRuleset(ctx);
    }

    @Override
    public Object visitUnknownRuleset(CSS3Parser.UnknownRulesetContext ctx) {
        insert(ctx);
        return super.visitUnknownRuleset(ctx);
    }

    @Override
    public Object visitDeclarationList(CSS3Parser.DeclarationListContext ctx) {
        insert(ctx);
        return super.visitDeclarationList(ctx);
    }

    @Override
    public Object visitKnownDeclaration(CSS3Parser.KnownDeclarationContext ctx) {
        insert(ctx);
        return super.visitKnownDeclaration(ctx);
    }

    @Override
    public Object visitUnknownDeclaration(CSS3Parser.UnknownDeclarationContext ctx) {
        insert(ctx);
        return super.visitUnknownDeclaration(ctx);
    }

    @Override
    public Object visitPrio(CSS3Parser.PrioContext ctx) {
        insert(ctx);
        return super.visitPrio(ctx);
    }

    @Override
    public Object visitValue(CSS3Parser.ValueContext ctx) {
        insert(ctx);
        return super.visitValue(ctx);
    }

    @Override
    public Object visitExpr(CSS3Parser.ExprContext ctx) {
        insert(ctx);
        return super.visitExpr(ctx);
    }

    @Override
    public Object visitKnownTerm(CSS3Parser.KnownTermContext ctx) {
        insert(ctx);
        return super.visitKnownTerm(ctx);
    }

    @Override
    public Object visitUnknownTerm(CSS3Parser.UnknownTermContext ctx) {
        insert(ctx);
        return super.visitUnknownTerm(ctx);
    }

    @Override
    public Object visitBadTerm(CSS3Parser.BadTermContext ctx) {
        insert(ctx);
        return super.visitBadTerm(ctx);
    }

    @Override
    public Object visitFunction(CSS3Parser.FunctionContext ctx) {
        insert(ctx);
        return super.visitFunction(ctx);
    }

    @Override
    public Object visitDxImageTransform(CSS3Parser.DxImageTransformContext ctx) {
        insert(ctx);
        return super.visitDxImageTransform(ctx);
    }

    @Override
    public Object visitHexcolor(CSS3Parser.HexcolorContext ctx) {
        insert(ctx);
        return super.visitHexcolor(ctx);
    }

    @Override
    public Object visitNumber(CSS3Parser.NumberContext ctx) {
        insert(ctx);
        return super.visitNumber(ctx);
    }

    @Override
    public Object visitPercentage(CSS3Parser.PercentageContext ctx) {
        insert(ctx);
        return super.visitPercentage(ctx);
    }

    @Override
    public Object visitDimension(CSS3Parser.DimensionContext ctx) {
        insert(ctx);
        return super.visitDimension(ctx);
    }

    @Override
    public Object visitUnknownDimension(CSS3Parser.UnknownDimensionContext ctx) {
        insert(ctx);
        return super.visitUnknownDimension(ctx);
    }

    @Override
    public Object visitAny(CSS3Parser.AnyContext ctx) {
        insert(ctx);
        return super.visitAny(ctx);
    }

    @Override
    public Object visitUnknownAtRule(CSS3Parser.UnknownAtRuleContext ctx) {
        insert(ctx);
        return super.visitUnknownAtRule(ctx);
    }

    @Override
    public Object visitAtKeyword(CSS3Parser.AtKeywordContext ctx) {
        insert(ctx);
        return super.visitAtKeyword(ctx);
    }

    @Override
    public Object visitUnused(CSS3Parser.UnusedContext ctx) {
        insert(ctx);
        return super.visitUnused(ctx);
    }

    @Override
    public Object visitBlock(CSS3Parser.BlockContext ctx) {
        insert(ctx);
        return super.visitBlock(ctx);
    }

    @Override
    public Object visitNestedStatement(CSS3Parser.NestedStatementContext ctx) {
        insert(ctx);
        return super.visitNestedStatement(ctx);
    }

    @Override
    public Object visitGroupRuleBody(CSS3Parser.GroupRuleBodyContext ctx) {
        insert(ctx);
        return super.visitGroupRuleBody(ctx);
    }

    @Override
    public Object visitSupportsRule(CSS3Parser.SupportsRuleContext ctx) {
        insert(ctx);
        return super.visitSupportsRule(ctx);
    }

    @Override
    public Object visitSupportsCondition(CSS3Parser.SupportsConditionContext ctx) {
        insert(ctx);
        return super.visitSupportsCondition(ctx);
    }

    @Override
    public Object visitSupportsConditionInParens(CSS3Parser.SupportsConditionInParensContext ctx) {
        insert(ctx);
        return super.visitSupportsConditionInParens(ctx);
    }

    @Override
    public Object visitSupportsNegation(CSS3Parser.SupportsNegationContext ctx) {
        insert(ctx);
        return super.visitSupportsNegation(ctx);
    }

    @Override
    public Object visitSupportsConjunction(CSS3Parser.SupportsConjunctionContext ctx) {
        insert(ctx);
        return super.visitSupportsConjunction(ctx);
    }

    @Override
    public Object visitSupportsDisjunction(CSS3Parser.SupportsDisjunctionContext ctx) {
        insert(ctx);
        return super.visitSupportsDisjunction(ctx);
    }

    @Override
    public Object visitSupportsDeclarationCondition(CSS3Parser.SupportsDeclarationConditionContext ctx) {
        insert(ctx);
        return super.visitSupportsDeclarationCondition(ctx);
    }

    @Override
    public Object visitGeneralEnclosed(CSS3Parser.GeneralEnclosedContext ctx) {
        insert(ctx);
        return super.visitGeneralEnclosed(ctx);
    }

    @Override
    public Object visitVar(CSS3Parser.VarContext ctx) {
        insert(ctx);
        return super.visitVar(ctx);
    }

    @Override
    public Object visitCalc(CSS3Parser.CalcContext ctx) {
        insert(ctx);
        return super.visitCalc(ctx);
    }

    @Override
    public Object visitCalcSum(CSS3Parser.CalcSumContext ctx) {
        insert(ctx);
        return super.visitCalcSum(ctx);
    }

    @Override
    public Object visitCalcProduct(CSS3Parser.CalcProductContext ctx) {
        insert(ctx);
        return super.visitCalcProduct(ctx);
    }

    @Override
    public Object visitCalcValue(CSS3Parser.CalcValueContext ctx) {
        insert(ctx);
        return super.visitCalcValue(ctx);
    }

    @Override
    public Object visitFontFaceRule(CSS3Parser.FontFaceRuleContext ctx) {
        insert(ctx);
        return super.visitFontFaceRule(ctx);
    }

    @Override
    public Object visitKnownFontFaceDeclaration(CSS3Parser.KnownFontFaceDeclarationContext ctx) {
        insert(ctx);
        return super.visitKnownFontFaceDeclaration(ctx);
    }

    @Override
    public Object visitUnknownFontFaceDeclaration(CSS3Parser.UnknownFontFaceDeclarationContext ctx) {
        insert(ctx);
        return super.visitUnknownFontFaceDeclaration(ctx);
    }

    @Override
    public Object visitKeyframesRule(CSS3Parser.KeyframesRuleContext ctx) {
        insert(ctx);
        return super.visitKeyframesRule(ctx);
    }

    @Override
    public Object visitKeyframesBlocks(CSS3Parser.KeyframesBlocksContext ctx) {
        insert(ctx);
        return super.visitKeyframesBlocks(ctx);
    }

    @Override
    public Object visitKeyframeSelector(CSS3Parser.KeyframeSelectorContext ctx) {
        insert(ctx);
        return super.visitKeyframeSelector(ctx);
    }

    @Override
    public Object visitViewport(CSS3Parser.ViewportContext ctx) {
        insert(ctx);
        return super.visitViewport(ctx);
    }

    @Override
    public Object visitCounterStyle(CSS3Parser.CounterStyleContext ctx) {
        insert(ctx);
        return super.visitCounterStyle(ctx);
    }

    @Override
    public Object visitFontFeatureValuesRule(CSS3Parser.FontFeatureValuesRuleContext ctx) {
        insert(ctx);
        return super.visitFontFeatureValuesRule(ctx);
    }

    @Override
    public Object visitFontFamilyNameList(CSS3Parser.FontFamilyNameListContext ctx) {
        insert(ctx);
        return super.visitFontFamilyNameList(ctx);
    }

    @Override
    public Object visitFontFamilyName(CSS3Parser.FontFamilyNameContext ctx) {
        insert(ctx);
        return super.visitFontFamilyName(ctx);
    }

    @Override
    public Object visitFeatureValueBlock(CSS3Parser.FeatureValueBlockContext ctx) {
        insert(ctx);
        return super.visitFeatureValueBlock(ctx);
    }

    @Override
    public Object visitFeatureType(CSS3Parser.FeatureTypeContext ctx) {
        ignore(ctx);
        return super.visitFeatureType(ctx);
    }

    @Override
    public Object visitFeatureValueDefinition(CSS3Parser.FeatureValueDefinitionContext ctx) {
        insert(ctx);
        return super.visitFeatureValueDefinition(ctx);
    }

    @Override
    public Object visitIdent(CSS3Parser.IdentContext ctx) {
        insert(ctx);
        return super.visitIdent(ctx);
    }

    @Override
    public Object visitWs(CSS3Parser.WsContext ctx) {
        ignore(ctx);
        return super.visitWs(ctx);
    }
}

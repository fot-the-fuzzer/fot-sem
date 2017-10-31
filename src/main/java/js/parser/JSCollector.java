package js.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

import java.util.HashMap;
import java.util.Map;

public class JSCollector extends ECMAScriptBaseVisitor {

    public Map<Interval, String> getMap() {
        return map;
    }

    private Map<Interval, String> map;

    public JSCollector() {
        this.map = new HashMap<>();
    }

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

    @Override
    public Object visitProgram(ECMAScriptParser.ProgramContext ctx) {
        ignore(ctx);
        return super.visitProgram(ctx);
    }

    @Override
    public Object visitSourceElements(ECMAScriptParser.SourceElementsContext ctx) {
        insert(ctx);
        return super.visitSourceElements(ctx);
    }

    @Override
    public Object visitSourceElement(ECMAScriptParser.SourceElementContext ctx) {
        insert(ctx);
        return super.visitSourceElement(ctx);
    }

    @Override
    public Object visitStatement(ECMAScriptParser.StatementContext ctx) {
        insert(ctx);
        return super.visitStatement(ctx);
    }

    // keep
    @Override
    public Object visitBlock(ECMAScriptParser.BlockContext ctx) {
        insert(ctx);
        return super.visitBlock(ctx);
    }

    @Override
    public Object visitStatementList(ECMAScriptParser.StatementListContext ctx) {
        insert(ctx);
        return super.visitStatementList(ctx);
    }

    @Override
    public Object visitVariableStatement(ECMAScriptParser.VariableStatementContext ctx) {
        insert(ctx);
        return super.visitVariableStatement(ctx);
    }

    @Override
    public Object visitVariableDeclarationList(ECMAScriptParser.VariableDeclarationListContext ctx) {
        insert(ctx);
        return super.visitVariableDeclarationList(ctx);
    }

    @Override
    public Object visitVariableDeclaration(ECMAScriptParser.VariableDeclarationContext ctx) {
//        insert(ctx);
        return super.visitVariableDeclaration(ctx);
    }

    @Override
    public Object visitInitialiser(ECMAScriptParser.InitialiserContext ctx) {
        insert(ctx);
        return super.visitInitialiser(ctx);
    }

    @Override
    public Object visitEmptyStatement(ECMAScriptParser.EmptyStatementContext ctx) {
        insert(ctx);
        return super.visitEmptyStatement(ctx);
    }

    @Override
    public Object visitExpressionStatement(ECMAScriptParser.ExpressionStatementContext ctx) {
        insert(ctx);
        return super.visitExpressionStatement(ctx);
    }

    @Override
    public Object visitIfStatement(ECMAScriptParser.IfStatementContext ctx) {
        insert(ctx);
        return super.visitIfStatement(ctx);
    }

    @Override
    public Object visitDoStatement(ECMAScriptParser.DoStatementContext ctx) {
        insert(ctx);
        return super.visitDoStatement(ctx);
    }

    @Override
    public Object visitWhileStatement(ECMAScriptParser.WhileStatementContext ctx) {
        insert(ctx);
        return super.visitWhileStatement(ctx);
    }

    @Override
    public Object visitForStatement(ECMAScriptParser.ForStatementContext ctx) {
        insert(ctx);
        return super.visitForStatement(ctx);
    }

    @Override
    public Object visitForVarStatement(ECMAScriptParser.ForVarStatementContext ctx) {
        insert(ctx);
        return super.visitForVarStatement(ctx);
    }

    @Override
    public Object visitForInStatement(ECMAScriptParser.ForInStatementContext ctx) {
        insert(ctx);
        return super.visitForInStatement(ctx);
    }

    @Override
    public Object visitForVarInStatement(ECMAScriptParser.ForVarInStatementContext ctx) {
        insert(ctx);
        return super.visitForVarInStatement(ctx);
    }

    @Override
    public Object visitContinueStatement(ECMAScriptParser.ContinueStatementContext ctx) {
        insert(ctx);
        return super.visitContinueStatement(ctx);
    }

    @Override
    public Object visitBreakStatement(ECMAScriptParser.BreakStatementContext ctx) {
        insert(ctx);
        return super.visitBreakStatement(ctx);
    }

    @Override
    public Object visitReturnStatement(ECMAScriptParser.ReturnStatementContext ctx) {
        insert(ctx);
        return super.visitReturnStatement(ctx);
    }

    @Override
    public Object visitWithStatement(ECMAScriptParser.WithStatementContext ctx) {
        insert(ctx);
        return super.visitWithStatement(ctx);
    }

    @Override
    public Object visitSwitchStatement(ECMAScriptParser.SwitchStatementContext ctx) {
        insert(ctx);
        return super.visitSwitchStatement(ctx);
    }

    @Override
    public Object visitCaseBlock(ECMAScriptParser.CaseBlockContext ctx) {
        insert(ctx);
        return super.visitCaseBlock(ctx);
    }

    @Override
    public Object visitCaseClauses(ECMAScriptParser.CaseClausesContext ctx) {
        insert(ctx);
        return super.visitCaseClauses(ctx);
    }

    @Override
    public Object visitCaseClause(ECMAScriptParser.CaseClauseContext ctx) {
        insert(ctx);
        return super.visitCaseClause(ctx);
    }

    @Override
    public Object visitDefaultClause(ECMAScriptParser.DefaultClauseContext ctx) {
        insert(ctx);
        return super.visitDefaultClause(ctx);
    }

    @Override
    public Object visitLabelledStatement(ECMAScriptParser.LabelledStatementContext ctx) {
        insert(ctx);
        return super.visitLabelledStatement(ctx);
    }

    @Override
    public Object visitThrowStatement(ECMAScriptParser.ThrowStatementContext ctx) {
        insert(ctx);
        return super.visitThrowStatement(ctx);
    }

    @Override
    public Object visitTryStatement(ECMAScriptParser.TryStatementContext ctx) {
        insert(ctx);
        return super.visitTryStatement(ctx);
    }

    @Override
    public Object visitCatchProduction(ECMAScriptParser.CatchProductionContext ctx) {
        insert(ctx);
        return super.visitCatchProduction(ctx);
    }

    @Override
    public Object visitFinallyProduction(ECMAScriptParser.FinallyProductionContext ctx) {
        insert(ctx);
        return super.visitFinallyProduction(ctx);
    }

    @Override
    public Object visitDebuggerStatement(ECMAScriptParser.DebuggerStatementContext ctx) {
        insert(ctx);
        return super.visitDebuggerStatement(ctx);
    }

    @Override
    public Object visitFunctionDeclaration(ECMAScriptParser.FunctionDeclarationContext ctx) {
        insert(ctx);
        return super.visitFunctionDeclaration(ctx);
    }

    @Override
    public Object visitFormalParameterList(ECMAScriptParser.FormalParameterListContext ctx) {
        insert(ctx);
        return super.visitFormalParameterList(ctx);
    }

    @Override
    public Object visitFunctionBody(ECMAScriptParser.FunctionBodyContext ctx) {
        insert(ctx);
        return super.visitFunctionBody(ctx);
    }

    @Override
    public Object visitArrayLiteral(ECMAScriptParser.ArrayLiteralContext ctx) {
        insert(ctx);
        return super.visitArrayLiteral(ctx);
    }

    @Override
    public Object visitElementList(ECMAScriptParser.ElementListContext ctx) {
        insert(ctx);
        return super.visitElementList(ctx);
    }

    @Override
    public Object visitElision(ECMAScriptParser.ElisionContext ctx) {
        insert(ctx);
        return super.visitElision(ctx);
    }

    @Override
    public Object visitObjectLiteral(ECMAScriptParser.ObjectLiteralContext ctx) {
        insert(ctx);
        return super.visitObjectLiteral(ctx);
    }

    @Override
    public Object visitPropertyNameAndValueList(ECMAScriptParser.PropertyNameAndValueListContext ctx) {
        insert(ctx);
        return super.visitPropertyNameAndValueList(ctx);
    }

    @Override
    public Object visitPropertyExpressionAssignment(ECMAScriptParser.PropertyExpressionAssignmentContext ctx) {
        insert(ctx);
        return super.visitPropertyExpressionAssignment(ctx);
    }

    @Override
    public Object visitPropertyGetter(ECMAScriptParser.PropertyGetterContext ctx) {
        insert(ctx);
        return super.visitPropertyGetter(ctx);
    }

    @Override
    public Object visitPropertySetter(ECMAScriptParser.PropertySetterContext ctx) {
        insert(ctx);
        return super.visitPropertySetter(ctx);
    }

    @Override
    public Object visitPropertyName(ECMAScriptParser.PropertyNameContext ctx) {
        insert(ctx);
        return super.visitPropertyName(ctx);
    }

    @Override
    public Object visitPropertySetParameterList(ECMAScriptParser.PropertySetParameterListContext ctx) {
        insert(ctx);
        return super.visitPropertySetParameterList(ctx);
    }

    @Override
    public Object visitArguments(ECMAScriptParser.ArgumentsContext ctx) {
        insert(ctx);
        return super.visitArguments(ctx);
    }

    @Override
    public Object visitArgumentList(ECMAScriptParser.ArgumentListContext ctx) {
        insert(ctx);
        return super.visitArgumentList(ctx);
    }

    @Override
    public Object visitExpressionSequence(ECMAScriptParser.ExpressionSequenceContext ctx) {
        insert(ctx);
        return super.visitExpressionSequence(ctx);
    }

    @Override
    public Object visitTernaryExpression(ECMAScriptParser.TernaryExpressionContext ctx) {
        insert(ctx);
        return super.visitTernaryExpression(ctx);
    }

    @Override
    public Object visitLogicalAndExpression(ECMAScriptParser.LogicalAndExpressionContext ctx) {
        insert(ctx);
        return super.visitLogicalAndExpression(ctx);
    }

    @Override
    public Object visitPreIncrementExpression(ECMAScriptParser.PreIncrementExpressionContext ctx) {
        insert(ctx);
        return super.visitPreIncrementExpression(ctx);
    }

    @Override
    public Object visitObjectLiteralExpression(ECMAScriptParser.ObjectLiteralExpressionContext ctx) {
        insert(ctx);
        return super.visitObjectLiteralExpression(ctx);
    }

    @Override
    public Object visitInExpression(ECMAScriptParser.InExpressionContext ctx) {
        insert(ctx);
        return super.visitInExpression(ctx);
    }

    @Override
    public Object visitLogicalOrExpression(ECMAScriptParser.LogicalOrExpressionContext ctx) {
        insert(ctx);
        return super.visitLogicalOrExpression(ctx);
    }

    @Override
    public Object visitNotExpression(ECMAScriptParser.NotExpressionContext ctx) {
        insert(ctx);
        return super.visitNotExpression(ctx);
    }

    @Override
    public Object visitPreDecreaseExpression(ECMAScriptParser.PreDecreaseExpressionContext ctx) {
        insert(ctx);
        return super.visitPreDecreaseExpression(ctx);
    }

    @Override
    public Object visitArgumentsExpression(ECMAScriptParser.ArgumentsExpressionContext ctx) {
        insert(ctx);
        return super.visitArgumentsExpression(ctx);
    }

    @Override
    public Object visitThisExpression(ECMAScriptParser.ThisExpressionContext ctx) {
        insert(ctx);
        return super.visitThisExpression(ctx);
    }

    @Override
    public Object visitFunctionExpression(ECMAScriptParser.FunctionExpressionContext ctx) {
        insert(ctx);
        return super.visitFunctionExpression(ctx);
    }

    @Override
    public Object visitUnaryMinusExpression(ECMAScriptParser.UnaryMinusExpressionContext ctx) {
        insert(ctx);
        return super.visitUnaryMinusExpression(ctx);
    }

    @Override
    public Object visitAssignmentExpression(ECMAScriptParser.AssignmentExpressionContext ctx) {
        insert(ctx);
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public Object visitPostDecreaseExpression(ECMAScriptParser.PostDecreaseExpressionContext ctx) {
        insert(ctx);
        return super.visitPostDecreaseExpression(ctx);
    }

    @Override
    public Object visitTypeofExpression(ECMAScriptParser.TypeofExpressionContext ctx) {
        insert(ctx);
        return super.visitTypeofExpression(ctx);
    }

    @Override
    public Object visitInstanceofExpression(ECMAScriptParser.InstanceofExpressionContext ctx) {
        insert(ctx);
        return super.visitInstanceofExpression(ctx);
    }

    @Override
    public Object visitUnaryPlusExpression(ECMAScriptParser.UnaryPlusExpressionContext ctx) {
        insert(ctx);
        return super.visitUnaryPlusExpression(ctx);
    }

    @Override
    public Object visitDeleteExpression(ECMAScriptParser.DeleteExpressionContext ctx) {
        insert(ctx);
        return super.visitDeleteExpression(ctx);
    }

    @Override
    public Object visitEqualityExpression(ECMAScriptParser.EqualityExpressionContext ctx) {
        insert(ctx);
        return super.visitEqualityExpression(ctx);
    }

    @Override
    public Object visitBitXOrExpression(ECMAScriptParser.BitXOrExpressionContext ctx) {
        insert(ctx);
        return super.visitBitXOrExpression(ctx);
    }

    @Override
    public Object visitMultiplicativeExpression(ECMAScriptParser.MultiplicativeExpressionContext ctx) {
        insert(ctx);
        return super.visitMultiplicativeExpression(ctx);
    }

    @Override
    public Object visitBitShiftExpression(ECMAScriptParser.BitShiftExpressionContext ctx) {
        insert(ctx);
        return super.visitBitShiftExpression(ctx);
    }

    @Override
    public Object visitParenthesizedExpression(ECMAScriptParser.ParenthesizedExpressionContext ctx) {
        insert(ctx);
        return super.visitParenthesizedExpression(ctx);
    }

    @Override
    public Object visitAdditiveExpression(ECMAScriptParser.AdditiveExpressionContext ctx) {
        insert(ctx);
        return super.visitAdditiveExpression(ctx);
    }

    @Override
    public Object visitRelationalExpression(ECMAScriptParser.RelationalExpressionContext ctx) {
        insert(ctx);
        return super.visitRelationalExpression(ctx);
    }

    @Override
    public Object visitPostIncrementExpression(ECMAScriptParser.PostIncrementExpressionContext ctx) {
        insert(ctx);
        return super.visitPostIncrementExpression(ctx);
    }

    @Override
    public Object visitBitNotExpression(ECMAScriptParser.BitNotExpressionContext ctx) {
        insert(ctx);
        return super.visitBitNotExpression(ctx);
    }

    @Override
    public Object visitNewExpression(ECMAScriptParser.NewExpressionContext ctx) {
        insert(ctx);
        return super.visitNewExpression(ctx);
    }

    @Override
    public Object visitLiteralExpression(ECMAScriptParser.LiteralExpressionContext ctx) {
        insert(ctx);
        return super.visitLiteralExpression(ctx);
    }

    @Override
    public Object visitArrayLiteralExpression(ECMAScriptParser.ArrayLiteralExpressionContext ctx) {
        insert(ctx);
        return super.visitArrayLiteralExpression(ctx);
    }

    @Override
    public Object visitMemberDotExpression(ECMAScriptParser.MemberDotExpressionContext ctx) {
        insert(ctx);
        return super.visitMemberDotExpression(ctx);
    }

    @Override
    public Object visitMemberIndexExpression(ECMAScriptParser.MemberIndexExpressionContext ctx) {
        insert(ctx);
        return super.visitMemberIndexExpression(ctx);
    }

    @Override
    public Object visitIdentifierExpression(ECMAScriptParser.IdentifierExpressionContext ctx) {
        insert(ctx);
        return super.visitIdentifierExpression(ctx);
    }

    @Override
    public Object visitBitAndExpression(ECMAScriptParser.BitAndExpressionContext ctx) {
        insert(ctx);
        return super.visitBitAndExpression(ctx);
    }

    @Override
    public Object visitBitOrExpression(ECMAScriptParser.BitOrExpressionContext ctx) {
        insert(ctx);
        return super.visitBitOrExpression(ctx);
    }

    @Override
    public Object visitAssignmentOperatorExpression(ECMAScriptParser.AssignmentOperatorExpressionContext ctx) {
        insert(ctx);
        return super.visitAssignmentOperatorExpression(ctx);
    }

    @Override
    public Object visitVoidExpression(ECMAScriptParser.VoidExpressionContext ctx) {
        insert(ctx);
        return super.visitVoidExpression(ctx);
    }

    @Override
    public Object visitAssignmentOperator(ECMAScriptParser.AssignmentOperatorContext ctx) {
        insert(ctx);
        return super.visitAssignmentOperator(ctx);
    }

    @Override
    public Object visitLiteral(ECMAScriptParser.LiteralContext ctx) {
        insert(ctx);
        return super.visitLiteral(ctx);
    }

    @Override
    public Object visitNumericLiteral(ECMAScriptParser.NumericLiteralContext ctx) {
        insert(ctx);
        return super.visitNumericLiteral(ctx);
    }

    @Override
    public Object visitIdentifierName(ECMAScriptParser.IdentifierNameContext ctx) {
        insert(ctx);
        return super.visitIdentifierName(ctx);
    }

    @Override
    public Object visitReservedWord(ECMAScriptParser.ReservedWordContext ctx) {
        insert(ctx);
        return super.visitReservedWord(ctx);
    }

    @Override
    public Object visitKeyword(ECMAScriptParser.KeywordContext ctx) {
        insert(ctx);
        return super.visitKeyword(ctx);
    }

    @Override
    public Object visitFutureReservedWord(ECMAScriptParser.FutureReservedWordContext ctx) {
        insert(ctx);
        return super.visitFutureReservedWord(ctx);
    }

    @Override
    public Object visitGetter(ECMAScriptParser.GetterContext ctx) {
        insert(ctx);
        return super.visitGetter(ctx);
    }

    @Override
    public Object visitSetter(ECMAScriptParser.SetterContext ctx) {
        insert(ctx);
        return super.visitSetter(ctx);
    }

    @Override
    public Object visitEos(ECMAScriptParser.EosContext ctx) {
        insert(ctx);
        return super.visitEos(ctx);
    }

    @Override
    public Object visitEof(ECMAScriptParser.EofContext ctx) {
        insert(ctx);
        return super.visitEof(ctx);
    }
}

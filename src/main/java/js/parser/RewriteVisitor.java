package js.parser;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class RewriteVisitor extends ECMAScriptBaseVisitor {

    private NodeKeeper keeper;
    private TokenStreamRewriter inner;

    public RewriteVisitor(NodeKeeper keeper, TokenStream stream) {
        this.keeper = keeper;
        inner = new TokenStreamRewriter(stream);
    }

    @Override
    public Object visitProgram(ECMAScriptParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Object visitSourceElements(ECMAScriptParser.SourceElementsContext ctx) {
        return super.visitSourceElements(ctx);
    }

    @Override
    public Object visitSourceElement(ECMAScriptParser.SourceElementContext ctx) {
        return super.visitSourceElement(ctx);
    }

    @Override
    public Object visitStatement(ECMAScriptParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public Object visitBlock(ECMAScriptParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public Object visitStatementList(ECMAScriptParser.StatementListContext ctx) {
        return super.visitStatementList(ctx);
    }

    @Override
    public Object visitVariableStatement(ECMAScriptParser.VariableStatementContext ctx) {
        return super.visitVariableStatement(ctx);
    }

    @Override
    public Object visitVariableDeclarationList(ECMAScriptParser.VariableDeclarationListContext ctx) {
        return super.visitVariableDeclarationList(ctx);
    }

    @Override
    public Object visitVariableDeclaration(ECMAScriptParser.VariableDeclarationContext ctx) {
        return super.visitVariableDeclaration(ctx);
    }

    @Override
    public Object visitInitialiser(ECMAScriptParser.InitialiserContext ctx) {
        return super.visitInitialiser(ctx);
    }

    @Override
    public Object visitEmptyStatement(ECMAScriptParser.EmptyStatementContext ctx) {
        return super.visitEmptyStatement(ctx);
    }

    @Override
    public Object visitExpressionStatement(ECMAScriptParser.ExpressionStatementContext ctx) {
        return super.visitExpressionStatement(ctx);
    }

    @Override
    public Object visitIfStatement(ECMAScriptParser.IfStatementContext ctx) {
        return super.visitIfStatement(ctx);
    }

    @Override
    public Object visitDoStatement(ECMAScriptParser.DoStatementContext ctx) {
        return super.visitDoStatement(ctx);
    }

    @Override
    public Object visitWhileStatement(ECMAScriptParser.WhileStatementContext ctx) {
        return super.visitWhileStatement(ctx);
    }

    @Override
    public Object visitForStatement(ECMAScriptParser.ForStatementContext ctx) {
        return super.visitForStatement(ctx);
    }

    @Override
    public Object visitForVarStatement(ECMAScriptParser.ForVarStatementContext ctx) {
        return super.visitForVarStatement(ctx);
    }

    @Override
    public Object visitForInStatement(ECMAScriptParser.ForInStatementContext ctx) {
        return super.visitForInStatement(ctx);
    }

    @Override
    public Object visitForVarInStatement(ECMAScriptParser.ForVarInStatementContext ctx) {
        return super.visitForVarInStatement(ctx);
    }

    @Override
    public Object visitContinueStatement(ECMAScriptParser.ContinueStatementContext ctx) {
        return super.visitContinueStatement(ctx);
    }

    @Override
    public Object visitBreakStatement(ECMAScriptParser.BreakStatementContext ctx) {
        return super.visitBreakStatement(ctx);
    }

    @Override
    public Object visitReturnStatement(ECMAScriptParser.ReturnStatementContext ctx) {
        return super.visitReturnStatement(ctx);
    }

    @Override
    public Object visitWithStatement(ECMAScriptParser.WithStatementContext ctx) {
        return super.visitWithStatement(ctx);
    }

    @Override
    public Object visitSwitchStatement(ECMAScriptParser.SwitchStatementContext ctx) {
        return super.visitSwitchStatement(ctx);
    }

    @Override
    public Object visitCaseBlock(ECMAScriptParser.CaseBlockContext ctx) {
        return super.visitCaseBlock(ctx);
    }

    @Override
    public Object visitCaseClauses(ECMAScriptParser.CaseClausesContext ctx) {
        return super.visitCaseClauses(ctx);
    }

    @Override
    public Object visitCaseClause(ECMAScriptParser.CaseClauseContext ctx) {
        return super.visitCaseClause(ctx);
    }

    @Override
    public Object visitDefaultClause(ECMAScriptParser.DefaultClauseContext ctx) {
        return super.visitDefaultClause(ctx);
    }

    @Override
    public Object visitLabelledStatement(ECMAScriptParser.LabelledStatementContext ctx) {
        return super.visitLabelledStatement(ctx);
    }

    @Override
    public Object visitThrowStatement(ECMAScriptParser.ThrowStatementContext ctx) {
        return super.visitThrowStatement(ctx);
    }

    @Override
    public Object visitTryStatement(ECMAScriptParser.TryStatementContext ctx) {
        return super.visitTryStatement(ctx);
    }

    @Override
    public Object visitCatchProduction(ECMAScriptParser.CatchProductionContext ctx) {
        return super.visitCatchProduction(ctx);
    }

    @Override
    public Object visitFinallyProduction(ECMAScriptParser.FinallyProductionContext ctx) {
        return super.visitFinallyProduction(ctx);
    }

    @Override
    public Object visitDebuggerStatement(ECMAScriptParser.DebuggerStatementContext ctx) {
        return super.visitDebuggerStatement(ctx);
    }

    @Override
    public Object visitFunctionDeclaration(ECMAScriptParser.FunctionDeclarationContext ctx) {
        return super.visitFunctionDeclaration(ctx);
    }

    @Override
    public Object visitFormalParameterList(ECMAScriptParser.FormalParameterListContext ctx) {
        return super.visitFormalParameterList(ctx);
    }

    @Override
    public Object visitFunctionBody(ECMAScriptParser.FunctionBodyContext ctx) {
        return super.visitFunctionBody(ctx);
    }

    @Override
    public Object visitArrayLiteral(ECMAScriptParser.ArrayLiteralContext ctx) {
        return super.visitArrayLiteral(ctx);
    }

    @Override
    public Object visitElementList(ECMAScriptParser.ElementListContext ctx) {
        return super.visitElementList(ctx);
    }

    @Override
    public Object visitElision(ECMAScriptParser.ElisionContext ctx) {
        return super.visitElision(ctx);
    }

    @Override
    public Object visitObjectLiteral(ECMAScriptParser.ObjectLiteralContext ctx) {
        return super.visitObjectLiteral(ctx);
    }

    @Override
    public Object visitPropertyNameAndValueList(ECMAScriptParser.PropertyNameAndValueListContext ctx) {
        return super.visitPropertyNameAndValueList(ctx);
    }

    @Override
    public Object visitPropertyExpressionAssignment(ECMAScriptParser.PropertyExpressionAssignmentContext ctx) {
        return super.visitPropertyExpressionAssignment(ctx);
    }

    @Override
    public Object visitPropertyGetter(ECMAScriptParser.PropertyGetterContext ctx) {
        return super.visitPropertyGetter(ctx);
    }

    @Override
    public Object visitPropertySetter(ECMAScriptParser.PropertySetterContext ctx) {
        return super.visitPropertySetter(ctx);
    }

    @Override
    public Object visitPropertyName(ECMAScriptParser.PropertyNameContext ctx) {
        return super.visitPropertyName(ctx);
    }

    @Override
    public Object visitPropertySetParameterList(ECMAScriptParser.PropertySetParameterListContext ctx) {
        return super.visitPropertySetParameterList(ctx);
    }

    @Override
    public Object visitArguments(ECMAScriptParser.ArgumentsContext ctx) {
        return super.visitArguments(ctx);
    }

    @Override
    public Object visitArgumentList(ECMAScriptParser.ArgumentListContext ctx) {
        return super.visitArgumentList(ctx);
    }

    @Override
    public Object visitExpressionSequence(ECMAScriptParser.ExpressionSequenceContext ctx) {
        return super.visitExpressionSequence(ctx);
    }

    @Override
    public Object visitTernaryExpression(ECMAScriptParser.TernaryExpressionContext ctx) {
        return super.visitTernaryExpression(ctx);
    }

    @Override
    public Object visitLogicalAndExpression(ECMAScriptParser.LogicalAndExpressionContext ctx) {
        return super.visitLogicalAndExpression(ctx);
    }

    @Override
    public Object visitPreIncrementExpression(ECMAScriptParser.PreIncrementExpressionContext ctx) {
        return super.visitPreIncrementExpression(ctx);
    }

    @Override
    public Object visitObjectLiteralExpression(ECMAScriptParser.ObjectLiteralExpressionContext ctx) {
        return super.visitObjectLiteralExpression(ctx);
    }

    @Override
    public Object visitInExpression(ECMAScriptParser.InExpressionContext ctx) {
        return super.visitInExpression(ctx);
    }

    @Override
    public Object visitLogicalOrExpression(ECMAScriptParser.LogicalOrExpressionContext ctx) {
        return super.visitLogicalOrExpression(ctx);
    }

    @Override
    public Object visitNotExpression(ECMAScriptParser.NotExpressionContext ctx) {
        return super.visitNotExpression(ctx);
    }

    @Override
    public Object visitPreDecreaseExpression(ECMAScriptParser.PreDecreaseExpressionContext ctx) {
        return super.visitPreDecreaseExpression(ctx);
    }

    @Override
    public Object visitArgumentsExpression(ECMAScriptParser.ArgumentsExpressionContext ctx) {
        return super.visitArgumentsExpression(ctx);
    }

    @Override
    public Object visitThisExpression(ECMAScriptParser.ThisExpressionContext ctx) {
        return super.visitThisExpression(ctx);
    }

    @Override
    public Object visitFunctionExpression(ECMAScriptParser.FunctionExpressionContext ctx) {
        return super.visitFunctionExpression(ctx);
    }

    @Override
    public Object visitUnaryMinusExpression(ECMAScriptParser.UnaryMinusExpressionContext ctx) {
        return super.visitUnaryMinusExpression(ctx);
    }

    @Override
    public Object visitAssignmentExpression(ECMAScriptParser.AssignmentExpressionContext ctx) {
        return super.visitAssignmentExpression(ctx);
    }

    @Override
    public Object visitPostDecreaseExpression(ECMAScriptParser.PostDecreaseExpressionContext ctx) {
        return super.visitPostDecreaseExpression(ctx);
    }

    @Override
    public Object visitTypeofExpression(ECMAScriptParser.TypeofExpressionContext ctx) {
        return super.visitTypeofExpression(ctx);
    }

    @Override
    public Object visitInstanceofExpression(ECMAScriptParser.InstanceofExpressionContext ctx) {
        return super.visitInstanceofExpression(ctx);
    }

    @Override
    public Object visitUnaryPlusExpression(ECMAScriptParser.UnaryPlusExpressionContext ctx) {
        return super.visitUnaryPlusExpression(ctx);
    }

    @Override
    public Object visitDeleteExpression(ECMAScriptParser.DeleteExpressionContext ctx) {
        return super.visitDeleteExpression(ctx);
    }

    @Override
    public Object visitEqualityExpression(ECMAScriptParser.EqualityExpressionContext ctx) {
        return super.visitEqualityExpression(ctx);
    }

    @Override
    public Object visitBitXOrExpression(ECMAScriptParser.BitXOrExpressionContext ctx) {
        return super.visitBitXOrExpression(ctx);
    }

    @Override
    public Object visitMultiplicativeExpression(ECMAScriptParser.MultiplicativeExpressionContext ctx) {
        return super.visitMultiplicativeExpression(ctx);
    }

    @Override
    public Object visitBitShiftExpression(ECMAScriptParser.BitShiftExpressionContext ctx) {
        return super.visitBitShiftExpression(ctx);
    }

    @Override
    public Object visitParenthesizedExpression(ECMAScriptParser.ParenthesizedExpressionContext ctx) {
        return super.visitParenthesizedExpression(ctx);
    }

    @Override
    public Object visitAdditiveExpression(ECMAScriptParser.AdditiveExpressionContext ctx) {
        return super.visitAdditiveExpression(ctx);
    }

    @Override
    public Object visitRelationalExpression(ECMAScriptParser.RelationalExpressionContext ctx) {
        return super.visitRelationalExpression(ctx);
    }

    @Override
    public Object visitPostIncrementExpression(ECMAScriptParser.PostIncrementExpressionContext ctx) {
        return super.visitPostIncrementExpression(ctx);
    }

    @Override
    public Object visitBitNotExpression(ECMAScriptParser.BitNotExpressionContext ctx) {
        return super.visitBitNotExpression(ctx);
    }

    @Override
    public Object visitNewExpression(ECMAScriptParser.NewExpressionContext ctx) {
        return super.visitNewExpression(ctx);
    }

    @Override
    public Object visitLiteralExpression(ECMAScriptParser.LiteralExpressionContext ctx) {
        return super.visitLiteralExpression(ctx);
    }

    @Override
    public Object visitArrayLiteralExpression(ECMAScriptParser.ArrayLiteralExpressionContext ctx) {
        return super.visitArrayLiteralExpression(ctx);
    }

    @Override
    public Object visitMemberDotExpression(ECMAScriptParser.MemberDotExpressionContext ctx) {
        return super.visitMemberDotExpression(ctx);
    }

    @Override
    public Object visitMemberIndexExpression(ECMAScriptParser.MemberIndexExpressionContext ctx) {
        return super.visitMemberIndexExpression(ctx);
    }

    @Override
    public Object visitIdentifierExpression(ECMAScriptParser.IdentifierExpressionContext ctx) {
        return super.visitIdentifierExpression(ctx);
    }

    @Override
    public Object visitBitAndExpression(ECMAScriptParser.BitAndExpressionContext ctx) {
        return super.visitBitAndExpression(ctx);
    }

    @Override
    public Object visitBitOrExpression(ECMAScriptParser.BitOrExpressionContext ctx) {
        return super.visitBitOrExpression(ctx);
    }

    @Override
    public Object visitAssignmentOperatorExpression(ECMAScriptParser.AssignmentOperatorExpressionContext ctx) {
        return super.visitAssignmentOperatorExpression(ctx);
    }

    @Override
    public Object visitVoidExpression(ECMAScriptParser.VoidExpressionContext ctx) {
        return super.visitVoidExpression(ctx);
    }

    @Override
    public Object visitAssignmentOperator(ECMAScriptParser.AssignmentOperatorContext ctx) {
        return super.visitAssignmentOperator(ctx);
    }

    @Override
    public Object visitLiteral(ECMAScriptParser.LiteralContext ctx) {
        return super.visitLiteral(ctx);
    }

    @Override
    public Object visitNumericLiteral(ECMAScriptParser.NumericLiteralContext ctx) {
        return super.visitNumericLiteral(ctx);
    }

    @Override
    public Object visitIdentifierName(ECMAScriptParser.IdentifierNameContext ctx) {
        return super.visitIdentifierName(ctx);
    }

    @Override
    public Object visitReservedWord(ECMAScriptParser.ReservedWordContext ctx) {
        return super.visitReservedWord(ctx);
    }

    @Override
    public Object visitKeyword(ECMAScriptParser.KeywordContext ctx) {
        return super.visitKeyword(ctx);
    }

    @Override
    public Object visitFutureReservedWord(ECMAScriptParser.FutureReservedWordContext ctx) {
        return super.visitFutureReservedWord(ctx);
    }

    @Override
    public Object visitGetter(ECMAScriptParser.GetterContext ctx) {
        return super.visitGetter(ctx);
    }

    @Override
    public Object visitSetter(ECMAScriptParser.SetterContext ctx) {
        return super.visitSetter(ctx);
    }

    @Override
    public Object visitEos(ECMAScriptParser.EosContext ctx) {
        return super.visitEos(ctx);
    }

    @Override
    public Object visitEof(ECMAScriptParser.EofContext ctx) {
        return super.visitEof(ctx);
    }
}

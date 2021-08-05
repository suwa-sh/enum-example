package me.suwash.enumtest;

enum ExpressionType {
    append(new AppendExpression()),
    replace(new ReplaceExpression());

    private final Expression expression;

    ExpressionType(Expression expression) {
        this.expression = expression;
    }

    static ExpressionType parse(final String exprDef) {
        // "replace('arg1', 'arg2')"
        var action = exprDef;
        if (hasParen(exprDef)) action = exprDef.substring(0, exprDef.indexOf("("));
        // "replace"
        var expressionType = ExpressionType.valueOf(action);

        // init
        expressionType.init(exprDef);
        return expressionType;
    }

    private static boolean hasParen(final String expressionDef) {
        return expressionDef.contains("(");
    }

    private void init(final String exprDef) {
        var argsDef = "";
        if (hasParen(exprDef)) argsDef = exprDef.substring(exprDef.indexOf("("));
        this.expression.init(argsDef);
    }

    String evaluate(final String value) {
        return expression.evaluate(value);
    }
}

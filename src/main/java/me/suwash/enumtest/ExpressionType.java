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
        var name = typeName(exprDef);
        // "replace"
        var type = ExpressionType.valueOf(name);

        type.init(exprDef);
        return type;
    }

    private static String typeName(final String exprDef) {
        var tmp = exprDef;
        if (hasParen(tmp)) tmp = substringBeforeParen(tmp);
        return tmp.trim();
    }

    private static boolean hasParen(final String value) {
        return value.contains("(");
    }

    private static String substringBeforeParen(final String value) {
        return value.substring(0, value.indexOf("("));
    }

    private void init(final String exprDef) {
        // "replace('arg1', 'arg2')"
        var argsDef = argsDef(exprDef);
        // "('arg1', 'arg2')"
        this.expression.init(argsDef);
    }

    private String argsDef(final String exprDef) {
        return exprDef.replace(typeName(exprDef), "");
    }

    String evaluate(final String value) {
        return expression.evaluate(value);
    }
}

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
        var name = substringBeforeParen(exprDef);
        // "replace"
        var type = ExpressionType.valueOf(name);

        type.init(exprDef);
        return type;
    }

    private static String substringBeforeParen(final String value) {
        var tmp = value;
        if (hasParen(tmp)) tmp = tmp.substring(0, tmp.indexOf("("));
        return tmp.trim();
    }

    private static boolean hasParen(final String value) {
        return value.contains("(");
    }

    private void init(final String exprDef) {
        var argsDef = substringEnclosedInParen(exprDef);
        this.expression.init(argsDef);
    }

    private String substringEnclosedInParen(final String value) {
        if (hasParen(value)) return value.substring(value.indexOf("("));
        return "";
    }

    String evaluate(final String value) {
        return expression.evaluate(value);
    }
}

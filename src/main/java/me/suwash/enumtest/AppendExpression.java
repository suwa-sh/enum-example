package me.suwash.enumtest;

class AppendExpression implements Expression {

    private Argument suffix;

    @Override
    public void init(final String argsDef) {
        var arguments = new Arguments(argsDef);
        arguments.assertLength(1);
        this.suffix = arguments.get(0);
    }

    @Override
    public String evaluate(final String value) {
        return value.concat(this.suffix.value());
    }
}

package me.suwash.enumtest;

class AppendExpression implements Expression {

    private Argument suffix;

    @Override
    public void init(final String argsDef) {
        var args = new Arguments(argsDef, 1);
        this.suffix = args.get(0);
    }

    @Override
    public String evaluate(final String value) {
        return value.concat(this.suffix.value());
    }
}

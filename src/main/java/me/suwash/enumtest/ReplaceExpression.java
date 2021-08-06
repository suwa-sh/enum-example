package me.suwash.enumtest;

class ReplaceExpression implements Expression {

    private Argument from;
    private Argument to;

    @Override
    public void init(final String argsDef) {
        var arguments = new Arguments(argsDef, 2);
        this.from = arguments.get(0);
        this.to = arguments.get(1);
    }

    @Override
    public String evaluate(final String value) {
        return value.replaceAll(this.from.value(), this.to.value());
    }
}

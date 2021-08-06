package me.suwash.enumtest;

interface Expression {
    void init(String argsDef);

    String evaluate(String value);
}

package me.suwash.enumtest;

interface Expression {
    void init(String argumentsDef);

    String evaluate(String value);
}

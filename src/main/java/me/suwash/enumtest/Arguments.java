package me.suwash.enumtest;

import java.util.ArrayList;
import java.util.List;

public class Arguments {
    private final String def;
    private final List<Argument> argumentList;

    Arguments(final String argsDef) {
        this.def = argsDef;
        this.argumentList = new ArrayList<>();
        if (argsDef == null || "".equals(argsDef)) return;

        // ('arg1', 'arg2')
        if (!isEnclosedInParen(argsDef))
            throw new IllegalArgumentException(String.format("()で括られていません。 def=%s", argsDef));
        var replaced = argsDef.substring(1, argsDef.length() - 1);

        // 'arg1', 'arg2'
        for (var element : replaced.split(",")) {
            this.argumentList.add(new Argument(element));
        }
    }

    private boolean isEnclosedInParen(final String argsDef) {
        return argsDef.startsWith("(") && argsDef.endsWith(")");
    }

    int size() {
        return this.argumentList.size();
    }

    Argument get(final int index) {
        return this.argumentList.get(index);
    }

    public void assertLength(final int length) {
        if (size() != length)
            throw new IllegalArgumentException(String.format("引数が%dつではありません。def=%s", length, this.def));
    }
}

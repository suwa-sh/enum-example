package me.suwash.enumtest;

import java.util.ArrayList;
import java.util.List;

class Arguments {
    private final String def;
    private final List<Argument> argList;

    Arguments(final String argsDef, final int length) {
        this.def = argsDef;
        this.argList = new ArrayList<>();

        // "('arg1', 'arg2')"
        var removed = removeParen(argsDef);
        // "'arg1', 'arg2'"
        for (var elem : removed.split(",")) {
            // "'arg1'", " 'arg2'"
            this.argList.add(new Argument(elem));
        }

        assertLength(length);
    }

    private String removeParen(String value) {
        var tmp = value.trim();
        if (!isEnclosedInParen(tmp))
            throw new IllegalArgumentException(String.format("()で括られていません。 定義=%s", this.def));
        return tmp.substring(1, tmp.length() - 1);
    }

    private boolean isEnclosedInParen(final String value) {
        return value.startsWith("(") && value.endsWith(")");
    }

    private void assertLength(final int length) {
        if (this.argList.size() != length)
            throw new IllegalArgumentException(String.format("引数の数が想定外です。引数の数=%d, 定義=%s", length, this.def));
    }

    Argument get(final int index) {
        return this.argList.get(index);
    }
}

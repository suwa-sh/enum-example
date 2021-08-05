package me.suwash.enumtest;

class Argument {
    private final String value;

    Argument(final String argDef) {
        // "'arg1'", " 'arg2'"
        var value = argDef.trim();
        if (isEnclosedInCommas(value))
            value = value.substring(1, value.length() - 1);
        // "arg1", "arg2"
        this.value = value;
    }

    private boolean isEnclosedInCommas(String value) {
        return value.startsWith("'") && value.endsWith("'");
    }

    String value() {
        return this.value;
    }
}
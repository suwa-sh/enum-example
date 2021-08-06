package me.suwash.enumtest;

class Argument {
    private final String value;

    Argument(final String argDef) {
        // "'arg1'" | " 'arg2'"
        var tmp = argDef.trim();
        if (isEnclosedInQuotes(tmp)) tmp = removeQuotes(tmp);
        // "arg1" | "arg2"
        this.value = tmp;
    }

    private boolean isEnclosedInQuotes(String value) {
        return value.startsWith("'") && value.endsWith("'");
    }

    private String removeQuotes(String value) {
        return value.substring(1, value.length() - 1);
    }

    String value() {
        return this.value;
    }
}

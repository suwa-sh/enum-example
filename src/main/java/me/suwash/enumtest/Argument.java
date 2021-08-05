package me.suwash.enumtest;

class Argument {
    private final String value;

    Argument(final String argDef) {
        // "'arg1'", " 'arg2'"
        var tmp = argDef.trim();
        if (isEnclosedInCommas(tmp))
            tmp = tmp.substring(1, tmp.length() - 1);
        // "arg1", "arg2"
        this.value = tmp;
    }

    private boolean isEnclosedInCommas(String value) {
        return value.startsWith("'") && value.endsWith("'");
    }

    String value() {
        return this.value;
    }
}

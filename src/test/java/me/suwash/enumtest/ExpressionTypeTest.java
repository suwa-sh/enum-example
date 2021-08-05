package me.suwash.enumtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ExpressionTypeTest {
    @Test
    void test_replace() {
        var exprDef = "replace('arg1', 'arg2')";

        var expressionType = ExpressionType.parse(exprDef);
        expressionType.init(exprDef);
        var actual = expressionType.evaluate("arg1 を arg2 に置換します");

        assertEquals("arg2 を arg2 に置換します", actual);
    }

    @Test
    void test_関数名だけの場合() {
        var exprDef = "replace";

        var expressionType = ExpressionType.parse(exprDef);
        try {
            expressionType.init(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_存在しないExpressionの場合() {
        var exprDef = "notExists('arg1', 'arg2', 'arg3')";

        try {
            ExpressionType.parse(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_replace_引数がない場合() {
        var exprDef = "replace()";

        var expressionType = ExpressionType.parse(exprDef);
        try {
            expressionType.init(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_replace_引数が足りない場合() {
        var exprDef = "replace('arg1')";

        var expressionType = ExpressionType.parse(exprDef);
        try {
            expressionType.init(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_replace_引数が多い場合() {
        var exprDef = "replace('arg1', 'arg2', 'arg3')";

        var expressionType = ExpressionType.parse(exprDef);
        try {
            expressionType.init(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_replace_カッコが閉じられていない場合() {
        var exprDef = "replace('arg1', 'arg2'";

        var expressionType = ExpressionType.parse(exprDef);
        try {
            expressionType.init(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test_append() {
        var exprDef = "append('suffix')";

        var expressionType = ExpressionType.parse(exprDef);
        expressionType.init(exprDef);
        var actual = expressionType.evaluate("後ろにサフィックスが追加されます。");

        assertEquals("後ろにサフィックスが追加されます。suffix", actual);
    }
}
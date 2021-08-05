package me.suwash.enumtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ExpressionTypeTest {

    @Test
    void test_append() {
        var exprDef = "append('suffix')";

        var expressionType = ExpressionType.parse(exprDef);
        var actual = expressionType.evaluate("後ろにサフィックスが追加されます。");

        assertEquals("後ろにサフィックスが追加されます。suffix", actual);
    }

    @Test
    void test_replace() {
        var exprDef = "replace('arg1', 'arg2')";

        var expressionType = ExpressionType.parse(exprDef);
        var actual = expressionType.evaluate("arg1 を arg2 に置換します");

        assertEquals("arg2 を arg2 に置換します", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "notExists('arg1', 'arg2', 'arg3')", // 存在しないExpressionの場合
            "replace", // replace_関数名だけの場合
            "replace()", // replace_引数がない場合
            "replace('arg1')", /// replace_引数が足りない場合
            "replace('arg1', 'arg2', 'arg3')", // replace_引数が多い場合
            "replace('arg1', 'arg2'" // replace_カッコが閉じられていない場合
    })
    void test_異常系(String exprDef) {
        try {
            ExpressionType.parse(exprDef);
            fail("例外が発生する");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
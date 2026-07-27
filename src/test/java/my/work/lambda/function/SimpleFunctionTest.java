package my.work.lambda.function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFunctionTest {

    @ParameterizedTest
    @CsvSource({
            "a,A",
            "ab,AB",
            "aB,AB",
            "hELlO,HELLO",
            "10,10"
    })
    void whenCallApply_thenCallOneFunction(String input, String expected) {
        var actual = SimpleFunction.apply(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a,Aend",
            "ab,ABend",
            "aB,ABend",
            "hELlO,HELLOend",
            "10,10end"
    })
    void whenCallApplyAndThen_thenCallTwoFunctions(String input, String expected) {
        var actual = SimpleFunction.applyAndThen(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a,AEND",
            "ab,ABEND",
            "aB,ABEND",
            "hELlO,HELLOEND",
            "10,10END"
    })
    void whenCallApplyCompose_thenCallTwoFunctions(String input, String expected) {
        var actual = SimpleFunction.applyCompose(input);

        assertEquals(expected, actual);
    }

}
package my.work.lambda.function;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBiFunctionTest {

    @ParameterizedTest
    @CsvSource({
            "a, b, ab",
            "a, B, aB",
            "A, B, AB",
            "10, a, 10a"
    })
    void whenCallApply_thenCallOneBiFunction(String string1, String string2, String expected) {
        var actual = SimpleBiFunction.apply(string1, string2);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, b, AB",
            "a, B, AB",
            "A, B, AB",
            "10, a, 10A"
    })
    void whenCallApplyAndThen_thenCallOneBiFunctionAndOneFunction(String string1, String string2, String expected) {
        var actual = SimpleBiFunction.applyAndThen(string1, string2);

        assertEquals(expected, actual);
    }

}
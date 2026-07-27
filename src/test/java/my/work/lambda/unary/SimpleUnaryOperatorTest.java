package my.work.lambda.unary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleUnaryOperatorTest {

    @ParameterizedTest
    @CsvSource({
            "a,A",
            "aBc, ABC",
            "10,10",
            "4s,4S"
    })
    void whenCallApply_thenCallUnaryOperator(String input, String expected) {
        var actual = SimpleUnaryOperator.apply(input);

        assertEquals(expected, actual);
    }

}
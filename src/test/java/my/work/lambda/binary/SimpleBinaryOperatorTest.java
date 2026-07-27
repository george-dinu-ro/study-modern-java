package my.work.lambda.binary;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBinaryOperatorTest {

    @ParameterizedTest
    @CsvSource({
            "1,0,1",
            "1,2,3",
            "10,20,30"
    })
    void whenCallApply_thenCallBinaryOperator(Integer a, Integer b, Integer expected) {
        var actual = SimpleBinaryOperator.apply(a, b);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,1",
            "-10,-9,-10",
            "0,19,0",
            "10,34,10"
    })
    void whenCallMinBy_thenCallBinaryOperator(Integer a, Integer b, Integer expected) {
        var actual = SimpleBinaryOperator.minBy(a, b);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,2",
            "-10,-9,-9",
            "0,19,19",
            "10,34,34"
    })
    void whenCallMaxBy_thenCallBinaryOperator(Integer a, Integer b, Integer expected) {
        var actual = SimpleBinaryOperator.maxBy(a, b);

        assertEquals(expected, actual);
    }

}
package my.work.stream.reduce;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleReduceTest {

    @ParameterizedTest
    @MethodSource("initReduce")
    void whenCallGetSum_thenUseReduce(List<Integer> input, int expected) {
        var actual = SimpleReduce.getSum(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initReduce")
    void whenCallGetOptionalSum_thenUseReduce(List<Integer> input, int expected) {
        var actual = SimpleReduce.getOptionalSum(input);

        assertTrue(actual.isPresent());

        assertEquals(expected, actual.get());
    }

    public static Stream<Arguments> initReduce() {
        return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 5), 15));
    }

}
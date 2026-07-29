package my.work.stream.numeric;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleStreamVsNumericStreamTest {

    @ParameterizedTest
    @MethodSource("initList")
    void whenCallSumUsingStream_thenUseStream(List<Integer> list, int expected) {
        var actual = SimpleStreamVsNumericStream.sumUsingStream(list);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initList")
    void whenCallSumUsingIntStream_thenUseIntStream(List<Integer> list, int expected) {
        var actual = SimpleStreamVsNumericStream.sumUsingIntStream(list);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initList() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 15));
    }
}
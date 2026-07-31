package my.work.stream.terminal.summingandaveraging;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleSummingAveragingTest {

    @ParameterizedTest
    @MethodSource("initSumming")
    void whenCallSummingV1_thenUseSumming(List<String> input, int expected) {
        var actual = SimpleSummingAveraging.summingV1(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initSumming")
    void whenCallSummingV2_thenUseMapToInt(List<String> input, int expected) {
        var actual = SimpleSummingAveraging.summingV2(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("averagingSumming")
    void whenCallAveraging_thenUseAveraging(List<String> input, double expected) {
        var actual = SimpleSummingAveraging.averaging(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initSumming() {
        return Stream.of(Arguments.of(
                List.of("a", "aa", "aaa", "aaaa"), 10));
    }

    private static Stream<Arguments> averagingSumming() {
        return Stream.of(Arguments.of(
                List.of("a", "aa", "aaa", "aaaa"), 2.5D));
    }

}
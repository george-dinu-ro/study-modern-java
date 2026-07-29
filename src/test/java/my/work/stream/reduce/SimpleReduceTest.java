package my.work.stream.reduce;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    @ParameterizedTest
    @MethodSource("initMinWithDefault")
    void whenCallGetMinWithDefault_thenUseDefaultValue(List<Integer> input, int expected) {
        var actual = SimpleReduce.getMinWithDefault(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initOptionalMin")
    void whenCallGetOptionalMin_thenDontUseDefaultValue(List<Integer> input, Optional<Integer> expected) {
        var actual = SimpleReduce.getOptionalMin(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMaxWithDefault")
    void whenCallGetMaxWithDefault_thenUseDefaultValue(List<Integer> input, int expected) {
        var actual = SimpleReduce.getMaxWithDefault(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initOptionalMax")
    void whenCallGetOptionalMax_thenDontUseDefaultValue(List<Integer> input, Optional<Integer> expected) {
        var actual = SimpleReduce.getOptionalMax(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initReduce() {
        return Stream.of(Arguments.of(List.of(1, 2, 3, 4, 5), 15));
    }

    private static Stream<Arguments> initMinWithDefault() {
        return Stream.of(
                Arguments.of(List.of(1000, 0, -1000, 10000), -1000),
                Arguments.of(Collections.emptyList(), Integer.MAX_VALUE));
    }

    private static Stream<Arguments> initOptionalMin() {
        return Stream.of(
                Arguments.of(List.of(1000, 0, -1000, 10000), Optional.of(-1000)),
                Arguments.of(Collections.emptyList(), Optional.empty()));
    }

    private static Stream<Arguments> initMaxWithDefault() {
        return Stream.of(
                Arguments.of(List.of(1000, 0, 10000, -1000), 10000),
                Arguments.of(Collections.emptyList(), Integer.MIN_VALUE));
    }

    private static Stream<Arguments> initOptionalMax() {
        return Stream.of(
                Arguments.of(List.of(1000, 0, 10000, -1000), Optional.of(10000)),
                Arguments.of(Collections.emptyList(), Optional.empty()));
    }

}
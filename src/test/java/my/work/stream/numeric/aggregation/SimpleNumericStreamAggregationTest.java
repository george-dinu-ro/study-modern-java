package my.work.stream.numeric.aggregation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleNumericStreamAggregationTest {

    @ParameterizedTest
    @MethodSource("initCount")
    void whenCallCount_thenUseCount(IntStream intStream, long expected) {
        var actual = SimpleNumericStreamAggregation.count(intStream);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initSum")
    void whenCallSum_thenUseSum(IntStream intStream, long expected) {
        var actual = SimpleNumericStreamAggregation.sum(intStream);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMin")
    void whenCallMin_thenUseMin(IntStream intStream, OptionalInt expected) {
        var actual = SimpleNumericStreamAggregation.min(intStream);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMax")
    void whenCallMax_thenUseMax(IntStream intStream, OptionalInt expected) {
        var actual = SimpleNumericStreamAggregation.max(intStream);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initAverage")
    void whenCallAverage_thenUseAverage(IntStream intStream, OptionalDouble expected) {
        var actual = SimpleNumericStreamAggregation.average(intStream);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initCount() {
        return Stream.of(
                Arguments.of(IntStream.builder().build(), 0),
                Arguments.of(IntStream.range(0, 5), 5));
    }

    private static Stream<Arguments> initSum() {
        return Stream.of(
                Arguments.of(IntStream.builder().build(), 0),
                Arguments.of(IntStream.range(0, 5), 10));
    }

    private static Stream<Arguments> initMin() {
        return Stream.of(
                Arguments.of(IntStream.builder().build(), OptionalInt.empty()),
                Arguments.of(IntStream.range(0, 5), OptionalInt.of(0)));
    }

    private static Stream<Arguments> initMax() {
        return Stream.of(
                Arguments.of(IntStream.builder().build(), OptionalInt.empty()),
                Arguments.of(IntStream.range(0, 5), OptionalInt.of(4)));
    }

    private static Stream<Arguments> initAverage() {
        return Stream.of(
                Arguments.of(IntStream.builder().build(), OptionalDouble.empty()),
                Arguments.of(IntStream.range(0, 5), OptionalDouble.of(2)));
    }

}
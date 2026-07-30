package my.work.stream.numeric.boxing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class IntStreamBoxingTest {

    @ParameterizedTest
    @MethodSource("initBoxing")
    void whenCallBoxingV1_thenUseBoxed(IntStream input, Stream<Integer> expected) {
        var expectedList = expected.toList();
        var actual = IntStreamBoxing.boxingV1(input);
        var actualList = actual.toList();

        assertIterableEquals(expectedList, actualList);
    }

    @ParameterizedTest
    @MethodSource("initBoxing")
    void whenCallBoxingV2_thenUseMapToObj(IntStream input, Stream<Integer> expected) {
        var expectedList = expected.toList();
        var actual = IntStreamBoxing.boxingV2(input);
        var actualList = actual.toList();

        assertIterableEquals(expectedList, actualList);
    }

    @ParameterizedTest
    @MethodSource("initUnBoxing")
    void whenCallUnBoxing_thenUseMapToInt(Stream<Integer> input, IntStream expected) {
        var expectedArray = expected.toArray();
        var actual = IntStreamBoxing.unBoxing(input);
        var actualArray = actual.toArray();

        assertArrayEquals(expectedArray, actualArray);
    }

    private static Stream<Arguments> initBoxing() {
        return Stream.of(
                Arguments.of(
                        IntStream.of(1, 2, 3, 4, 5),
                        Stream.of(1, 2, 3, 4, 5)));
    }

    private static Stream<Arguments> initUnBoxing() {
        return Stream.of(
                Arguments.of(
                        Stream.of(1, 2, 3, 4, 5),
                        IntStream.of(1, 2, 3, 4, 5)));
    }

}
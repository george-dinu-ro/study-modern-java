package my.work.stream.flatmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SimpleFlatMapTest {

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallFlatMap_thenUseFlatMap(List<List<String>> input) {
        var expected = List.of("a", "b", "a", "a", "c", "d", "b", "e", "f");
        var actual = SimpleFlatMap.flatMap(input);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallFlatMapDistinct_thenUseFlatMapDistinct(List<List<String>> input) {
        var expected = List.of("a", "b", "c", "d", "e", "f");
        var actual = SimpleFlatMap.flatMapDistinct(input);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallFlatMapSorted_thenUseFlatMapSorted(List<List<String>> input) {
        var expected = List.of("a", "a", "a", "b", "b", "c", "d", "e", "f");
        var actual = SimpleFlatMap.flatMapSorted(input);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallFlatMapCount_thenUseFlatMapCount(List<List<String>> input) {
        var actual = SimpleFlatMap.flatMapCount(input);

        assertEquals(9, actual);
    }

    public static Stream<Arguments> initMap() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("a", "b", "a", "a"),
                                List.of("c", "d", "b", "e"),
                                List.of("f"))));
    }

}
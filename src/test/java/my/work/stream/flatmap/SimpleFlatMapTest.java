package my.work.stream.flatmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SimpleFlatMapTest {

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallFlatMap_thenUseFlatMap(List<List<String>> input, List<String> expected) {
        var actual = SimpleFlatMap.flatMap(input);

        assertIterableEquals(expected, actual);
    }

    public static Stream<Arguments> initMap() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                List.of("a", "b", "c"),
                                List.of("d", "e"),
                                List.of("f")),
                        List.of("a", "b", "c", "d", "e", "f")));
    }

}
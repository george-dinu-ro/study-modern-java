package my.work.stream.map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SimpleMapTest {

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallMap_thenUseMap(List<String> input, List<String> expected) {
        var actual = SimpleMap.map(input);

        assertIterableEquals(expected, actual);
    }

    public static Stream<Arguments> initMap() {
        return Stream.of(
                Arguments.of(
                        List.of("a", "aB", "aBC", "ABC", "1a", "10"),
                        List.of("A", "AB", "ABC", "ABC", "1A", "10")));
    }
}
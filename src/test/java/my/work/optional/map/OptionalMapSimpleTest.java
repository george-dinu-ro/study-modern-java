package my.work.optional.map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalMapSimpleTest {

    @ParameterizedTest
    @MethodSource("initMap")
    void whenCallMap_thenUseMap(String input, int expected) {
        var actual = OptionalMapSimple.map(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initMap() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(null, 0),
                Arguments.of("", 0),
                Arguments.of("hello", 5));
    }

}
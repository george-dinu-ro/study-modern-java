package my.work.optional.filter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalFilterSimpleTest {

    @ParameterizedTest
    @MethodSource("initFilter")
    void whenCallFilter_thenUseFilter(String input, String expected) {
        var actual = OptionalFilterSimple.filter(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initFilter() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of("", ""),
                Arguments.of("ab", ""),
                Arguments.of("abc", "abc"),
                Arguments.of("hello", "hello"));
    }

}
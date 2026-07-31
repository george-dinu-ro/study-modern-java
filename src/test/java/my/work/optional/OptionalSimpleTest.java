package my.work.optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalSimpleTest {

    @ParameterizedTest
    @MethodSource("initOfNullable")
    void whenCallOfNullable_thenUseOfNullable(String input, Optional<String> expected) {
        var actual = OptionalSimple.ofNullable(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initOf")
    void whenCallOf_thenUseOf(String input, Optional<String> expected) {
        var actual = OptionalSimple.of(input);

        assertEquals(expected, actual);
    }

    @Test
    void whenCallOfWithNull_thenThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> OptionalSimple.of(null));
    }

    @Test
    void whenCallEmpty_thenUseEmpty() {
        assertEquals(Optional.empty(), OptionalSimple.empty());
    }

    private static Stream<Arguments> initOfNullable() {
        return Stream.of(
                Arguments.of(null, Optional.empty()),
                Arguments.of("", Optional.of("")),
                Arguments.of("hello", Optional.of("hello")));
    }

    private static Stream<Arguments> initOf() {
        return Stream.of(
                Arguments.of("", Optional.of("")),
                Arguments.of("hello", Optional.of("hello")));
    }

}
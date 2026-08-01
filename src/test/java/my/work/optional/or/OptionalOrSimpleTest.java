package my.work.optional.or;

import my.work.ALogger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionalOrSimpleTest extends ALogger {

    @ParameterizedTest
    @MethodSource("initOrElse")
    void whenCallOrElse_thenUseOrElse(String input, String expected) {
        var actual = OptionalOrSimple.orElse(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initOrElse")
    void whenCallOrElseGet_thenUseOrElseGet(String input, String expected) {
        var actual = OptionalOrSimple.orElseGet(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initOrElseNotNull")
    void whenCallOrElseThrow_thenUseOrElseThrow(String input, String expected) {
        var actual = OptionalOrSimple.orElseThrow(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initOrElseNull")
    void whenCallOrElseThrowWithNull_thenThrowsException(String input, String expected) {
        assertThrows(
                NoSuchElementException.class,
                () -> OptionalOrSimple.orElseThrow(input));
    }

    @ParameterizedTest
    @MethodSource("initOrElse")
    void whenCallOrElseBehavior_thenUseOrElse(String input, String expected) {
        OptionalOrSimple.orElseBehavior(input);

        assertEquals(2, getMessagesSize());

        assertEquals("Inside orElse method", getMessage(0));

        assertEquals("orElse: %s".formatted(expected), getMessage(1));
    }

    @ParameterizedTest
    @MethodSource("initOrElseNull")
    void whenCallOrElseGetBehaviorWithNull_thenUseOrElseGet(String input, String expected) {
        OptionalOrSimple.OrElseGetBehavior(input);

        assertEquals(2, getMessagesSize());

        assertEquals("Inside orElseGet method", getMessage(0));

        assertEquals("orElseGet: %s".formatted(expected), getMessage(1));
    }

    @ParameterizedTest
    @MethodSource("initOrElseNotNull")
    void whenCallOrElseGetBehaviorWithNotNull_thenUseOrElseGet(String input, String expected) {
        OptionalOrSimple.OrElseGetBehavior(input);

        assertEquals(1, getMessagesSize());

        assertEquals("orElseGet: %s".formatted(expected), getMessage(0));
    }

    @Override
    protected Class<?> getLoggedClass() {
        return OptionalOrSimple.class;
    }

    private static Stream<Arguments> initOrElse() {
        return Stream.concat(initOrElseNull(), initOrElseNotNull());
    }

    private static Stream<Arguments> initOrElseNull() {
        return Stream.of(Arguments.of(null, "default"));
    }

    private static Stream<Arguments> initOrElseNotNull() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("hello", "hello"));
    }

}
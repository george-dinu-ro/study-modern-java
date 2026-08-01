package my.work.optional.present;

import my.work.ALogger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalPresentSimpleTest extends ALogger {

    @ParameterizedTest
    @MethodSource("initPresent")
    void whenCallIsPresent_thenUseIsPresent(String input, String expected) {
        var actual = OptionalPresentSimple.isPresent(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initPresentNull")
    void whenCallIfPresentWithNull_thenDontUseIfPresent(String input, String expected) {
        OptionalPresentSimple.ifPresent(input);

        assertEquals(0, getMessagesSize());
    }

    @ParameterizedTest
    @MethodSource("initPresentNotNull")
    void whenCallIfPresentWithNotNull_thenUseIfPresent(String input, String expected) {
        OptionalPresentSimple.ifPresent(input);

        assertEquals(2, getMessagesSize());

        assertEquals("Inside useOptional method", getMessage(0));

        assertEquals("value: %s".formatted(expected), getMessage(1));
    }

    @Override
    protected Class<?> getLoggedClass() {
        return OptionalPresentSimple.class;
    }

    private static Stream<Arguments> initPresent() {
        return Stream.concat(initPresentNull(), initPresentNotNull());
    }

    private static Stream<Arguments> initPresentNull() {
        return Stream.of(Arguments.of(null, "default"));
    }

    private static Stream<Arguments> initPresentNotNull() {
        return Stream.of(
                Arguments.of("", ""),
                Arguments.of("hello", "hello"));
    }

}
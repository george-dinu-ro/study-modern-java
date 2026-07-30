package my.work.stream.terminal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleJoiningTest {

    @ParameterizedTest
    @MethodSource("initSimpleJoining")
    void whenCallSimpleJoining_thenUseJustJoining(List<String> input, String expected) {
        var actual = SimpleJoining.simpleJoining(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initDelimiterJoining")
    void whenCallDelimiterJoining_thenUseJoiningWithDelimiter(List<String> input, String expected) {
        var actual = SimpleJoining.delimiterJoining(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initEnhancedJoining")
    void whenCallEnhancedJoining_thenUseJoiningWithDelimiterAndPrefixAndSuffix(List<String> input, String expected) {
        var actual = SimpleJoining.enhancedJoining(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initSimpleJoining() {
        return Stream.of(
                Arguments.of(List.of("a", "b", "c"), "abc"));
    }

    private static Stream<Arguments> initDelimiterJoining() {
        return Stream.of(
                Arguments.of(List.of("a", "b", "c"), "a, b, c"));
    }

    private static Stream<Arguments> initEnhancedJoining() {
        return Stream.of(
                Arguments.of(List.of("a", "b", "c"), "(a, b, c)"));
    }

}
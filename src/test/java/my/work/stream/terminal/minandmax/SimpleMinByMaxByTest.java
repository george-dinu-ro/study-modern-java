package my.work.stream.terminal.minandmax;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleMinByMaxByTest {

    @ParameterizedTest
    @MethodSource("initMin")
    void whenCallMinBy_thenUseMinBy(List<String> input, Optional<String> expected) {
        var actual = SimpleMinByMaxBy.minBy(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMin")
    void whenCallMin_thenUseMin(List<String> input, Optional<String> expected) {
        var actual = SimpleMinByMaxBy.min(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMax")
    void whenCallMaxBy_thenUseMaxBy(List<String> input, Optional<String> expected) {
        var actual = SimpleMinByMaxBy.maxBy(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMax")
    void whenCallMax_thenUseMax(List<String> input, Optional<String> expected) {
        var actual = SimpleMinByMaxBy.max(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initMin() {
        return Stream.of(
                Arguments.of(List.of("aaa", "aa", "a"), Optional.of("a")));
    }

    private static Stream<Arguments> initMax() {
        return Stream.of(
                Arguments.of(List.of("a", "aa", "aaa"), Optional.of("aaa")));
    }

}
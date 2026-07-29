package my.work.stream.match;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleMatchTest {

    @ParameterizedTest
    @MethodSource("initMatchAny")
    void whenCallMatchAnyGreaterThan_useMatchAny(List<Integer> list, boolean expected) {
        var actual = SimpleMatch.matchAnyGreaterThan(list);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMatchAll")
    void whenCallMatchAllGreaterThan_useMatchAll(List<Integer> list, boolean expected) {
        var actual = SimpleMatch.matchAllGreaterThan(list);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initMatchNone")
    void whenCallMatchNoneGreaterThan_useMatchNone(List<Integer> list, boolean expected) {
        var actual = SimpleMatch.matchNoneGreaterThan(list);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initMatchAny() {
        return Stream.of(
                Arguments.of(List.of(1, 5, 7, 2), true),
                Arguments.of(List.of(1, 3, 5, 2), false));
    }

    private static Stream<Arguments> initMatchAll() {
        return Stream.of(
                Arguments.of(List.of(8, 6, 11, 20), true),
                Arguments.of(List.of(10, 5, 40, 20), false));
    }

    private static Stream<Arguments> initMatchNone() {
        return Stream.of(
                Arguments.of(List.of(1, 4, 5, 3), true),
                Arguments.of(List.of(1, 5, 4, 6), false));
    }

}
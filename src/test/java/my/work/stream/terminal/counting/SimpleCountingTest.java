package my.work.stream.terminal.counting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCountingTest {

    @ParameterizedTest
    @MethodSource("initCount")
    void whenCallCount_thenUseCount(List<String> input, long expected) {
        var actual = SimpleCounting.count(input);

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> initCount() {
        return Stream.of(Arguments.of(List.of("a", "b", "c"), 3));
    }

}
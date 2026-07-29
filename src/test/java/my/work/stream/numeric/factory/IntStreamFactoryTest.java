package my.work.stream.numeric.factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class IntStreamFactoryTest {

    @ParameterizedTest
    @MethodSource("initRange")
    void whenCallRange_thenUseRange(List<Integer> expected) {
        var actual = IntStreamFactory.range();
        var actualAsList = actual.boxed().toList();

        assertEquals(actualAsList.size(), expected.size());

        assertIterableEquals(expected, actualAsList);
    }

    @ParameterizedTest
    @MethodSource("initRangeClosed")
    void whenCallRangeClosed_thenUseRangeClosed(List<Integer> expected) {
        var actual = IntStreamFactory.rangeClosed();
        var actualAsList = actual.boxed().toList();

        assertEquals(actualAsList.size(), expected.size());

        assertIterableEquals(expected, actualAsList);
    }

    private static Stream<Arguments> initRange() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4)));
    }

    private static Stream<Arguments> initRangeClosed() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)));
    }

}
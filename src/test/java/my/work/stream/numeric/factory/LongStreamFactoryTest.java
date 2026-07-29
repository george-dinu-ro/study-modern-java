package my.work.stream.numeric.factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class LongStreamFactoryTest {

    @ParameterizedTest
    @MethodSource("initRange")
    void whenCallRange_thenUseRange(List<Long> expected) {
        var actual = LongStreamFactory.range();
        var actualAsList = actual.boxed().toList();

        assertEquals(actualAsList.size(), expected.size());

        assertIterableEquals(expected, actualAsList);
    }

    @ParameterizedTest
    @MethodSource("initRangeClosed")
    void whenCallRangeClosed_thenUseRangeClosed(List<Long> expected) {
        var actual = LongStreamFactory.rangeClosed();
        var actualAsList = actual.boxed().toList();

        assertEquals(actualAsList.size(), expected.size());

        assertIterableEquals(expected, actualAsList);
    }

    private static Stream<Arguments> initRange() {
        return Stream.of(
                Arguments.of(List.of(1L, 2L, 3L, 4L)));
    }

    private static Stream<Arguments> initRangeClosed() {
        return Stream.of(
                Arguments.of(List.of(1L, 2L, 3L, 4L, 5L)));
    }

}
package my.work.stream.numeric.factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStreamFactoryTest {

    @ParameterizedTest
    @MethodSource("initRange")
    void whenCallRange_thenUseIntStreamRange(List<Double> expected) {
        var actual = DoubleStreamFactory.range();
        var actualAsList = actual.boxed().toList();

        assertEquals(actualAsList.size(), expected.size());

        assertIterableEquals(expected, actualAsList);
    }

    @ParameterizedTest
    @MethodSource("initRangeClosed")
    void whenCallRangeClosed_thenUseIntStreamRangeClosed(List<Integer> expected) {
        var actual = DoubleStreamFactory.rangeClosed();
        var actualAsList = actual.boxed().toList();

        assertEquals(actualAsList.size(), expected.size());

        assertIterableEquals(expected, actualAsList);
    }

    private static Stream<Arguments> initRange() {
        return Stream.of(
                Arguments.of(List.of(1D, 2D, 3D, 4D)));
    }

    private static Stream<Arguments> initRangeClosed() {
        return Stream.of(
                Arguments.of(List.of(1D, 2D, 3D, 4D, 5D)));
    }

}
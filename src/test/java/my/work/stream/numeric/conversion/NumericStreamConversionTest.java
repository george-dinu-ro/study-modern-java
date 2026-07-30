package my.work.stream.numeric.conversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NumericStreamConversionTest {

    @ParameterizedTest
    @MethodSource("initToDoubleStream")
    void whenCallToDoubleStream_thenConvertIntToDouble(IntStream input, DoubleStream expected) {
        var expectedArray = expected.toArray();
        var actual = NumericStreamConversion.toDoubleStream(input);
        var actualArray = actual.toArray();

        assertArrayEquals(expectedArray, actualArray);
    }

    @ParameterizedTest
    @MethodSource("initToIntStream")
    void whenCallToIntStream_thenConvertDoubleToInt(DoubleStream input, IntStream expected) {
        var expectedArray = expected.toArray();
        var actual = NumericStreamConversion.toIntStream(input);
        var actualArray = actual.toArray();

        assertArrayEquals(expectedArray, actualArray);
    }

    public static Stream<Arguments> initToDoubleStream() {
        return Stream.of(
                Arguments.of(
                        IntStream.range(1, 5),
                        IntStream.range(1, 5).asDoubleStream()));
    }

    public static Stream<Arguments> initToIntStream() {
        return Stream.of(
                Arguments.of(
                        IntStream.range(1, 5).asDoubleStream(),
                        IntStream.range(1, 5)));
    }

}
package my.work.stream.numeric.conversion;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumericStreamConversion {

    public static DoubleStream toDoubleStream(IntStream intStream) {
        return intStream.mapToDouble(x -> x);
    }

    public static IntStream toIntStream(DoubleStream doubleStream) {
        return doubleStream.mapToInt(x -> (int) x);
    }

}

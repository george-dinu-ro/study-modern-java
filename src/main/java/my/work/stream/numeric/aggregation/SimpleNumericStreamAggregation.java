package my.work.stream.numeric.aggregation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleNumericStreamAggregation {

    public static long count(IntStream intStream) {
        return intStream.count();
    }

    public static int sum(IntStream intStream) {
        return intStream.sum();
    }

    public static OptionalInt min(IntStream intStream) {
        return intStream.min();
    }

    public static OptionalInt max(IntStream intStream) {
        return intStream.max();
    }

    public static OptionalDouble average(IntStream intStream) {
        return intStream.average();
    }

}

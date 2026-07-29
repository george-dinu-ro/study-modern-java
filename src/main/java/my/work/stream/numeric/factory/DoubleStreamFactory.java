package my.work.stream.numeric.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleStreamFactory {

    public static DoubleStream range() {
        return IntStream.range(1, 5).asDoubleStream();
    }

    public static DoubleStream rangeClosed() {
        return IntStream.rangeClosed(1, 5).asDoubleStream();
    }

}

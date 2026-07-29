package my.work.stream.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleFactory {

    private static final UnaryOperator<String> FUNCTION = x -> String.valueOf((char) (x.charAt(0) + 1));

    private static Supplier<String> supplier() {
        var counter = new AtomicInteger('a');
        return () -> String.valueOf((char) counter.getAndIncrement());
    }

    public static Stream<String> of() {
        return Stream.of("a", "b", "c", "d", "e");
    }

    public static Stream<String> iterate() {
        return Stream.iterate("a", FUNCTION).limit(5);
    }

    public static Stream<String> generate() {
        return Stream.generate(supplier()).limit(5);
    }

}

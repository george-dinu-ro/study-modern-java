package my.work.stream.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleFactory {

    public static Stream<String> of() {
        return Stream.of("a", "b", "c", "d", "e");
    }

    public static Stream<String> iterate() {
        return Stream.iterate("a", x -> String.valueOf((char) (x.charAt(0) + 1))).limit(5);
    }

    public static Stream<String> generate() {
        var counter = new AtomicInteger('a');
        return Stream.generate(() -> String.valueOf((char) counter.getAndIncrement())).limit(5);
    }

}

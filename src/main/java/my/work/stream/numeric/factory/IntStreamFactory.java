package my.work.stream.numeric.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntStreamFactory {

    public static IntStream range() {
        return IntStream.range(1, 5);
    }

    public static IntStream rangeClosed() {
        return IntStream.rangeClosed(1, 5);
    }

}

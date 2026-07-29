package my.work.stream.numeric.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.LongStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LongStreamFactory {

    public static LongStream range() {
        return LongStream.range(1, 5);
    }

    public static LongStream rangeClosed() {
        return LongStream.rangeClosed(1, 5);
    }

}

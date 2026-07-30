package my.work.stream.numeric.boxing;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IntStreamBoxing {

    public static Stream<Integer> boxingV1(IntStream intStream) {
        return intStream.boxed();
    }

    public static Stream<Integer> boxingV2(IntStream intStream) {
        return intStream.mapToObj(Integer::valueOf);
    }

    public static IntStream unBoxing(Stream<Integer> stream) {
        return stream.mapToInt(Integer::intValue);
    }

}

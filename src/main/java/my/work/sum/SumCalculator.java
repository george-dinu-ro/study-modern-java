package my.work.sum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SumCalculator {

    public static int getImperativeSum(int maxNumber) {
        var sum = 0;

        for (var i = 1; i <= maxNumber; i++) {
            sum += i;
        }

        return sum;
    }

    public static int getDeclarativeSum(int maxNumber) {
        return IntStream.rangeClosed(1, maxNumber).sum();
    }

}

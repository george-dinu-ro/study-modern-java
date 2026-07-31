package my.work.stream.parallel;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;
import java.util.stream.IntStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleComparison {

    public static int serialStreamSum() {
        return IntStream.rangeClosed(1, 100_000_000).sum();
    }

    public static int parallelStreamSum() {
        return IntStream.rangeClosed(1, 100_000_000).parallel().sum();
    }

    public static long getExecutionTime(Supplier<Integer> supplier, int numberOfTimes) {
        var startTime = System.currentTimeMillis();
        doSum(supplier, numberOfTimes);
        var endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static void doSum(Supplier<Integer> supplier, int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            supplier.get();
        }
    }

}

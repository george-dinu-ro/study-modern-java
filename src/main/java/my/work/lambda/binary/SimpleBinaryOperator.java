package my.work.lambda.binary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.function.BinaryOperator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleBinaryOperator {

    private static final BinaryOperator<Integer> SUM = Integer::sum;

    private static final BinaryOperator<Integer> MIN_BY = BinaryOperator.minBy(Comparator.naturalOrder());

    private static final BinaryOperator<Integer> MAX_BY = BinaryOperator.maxBy(Comparator.naturalOrder());

    public static Integer apply(Integer a, Integer b) {
        return SUM.apply(a, b);
    }

    public static Integer minBy(Integer a, Integer b) {
        return MIN_BY.apply(a, b);
    }

    public static Integer maxBy(Integer a, Integer b) {
        return MAX_BY.apply(a, b);
    }

}

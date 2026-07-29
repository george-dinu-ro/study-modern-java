package my.work.stream.reduce;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleReduce {

    public static int getSum(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static Optional<Integer> getOptionalSum(List<Integer> list) {
        return list.stream().reduce(Integer::sum);
    }

    public static int getMinWithDefault(List<Integer> list) {
        return list.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    public static Optional<Integer> getOptionalMin(List<Integer> list) {
        return list.stream().reduce(Integer::min);
    }

    public static int getMaxWithDefault(List<Integer> list) {
        return list.stream().reduce(Integer.MIN_VALUE, Integer::max);
    }

    public static Optional<Integer> getOptionalMax(List<Integer> list) {
        return list.stream().reduce(Integer::max);
    }

    public static int getSumWithLimit(List<Integer> list, int limit) {
        return list.stream().limit(limit).reduce(0, Integer::sum);
    }

    public static int getSumWithSkip(List<Integer> list, int skip) {
        return list.stream().skip(skip).reduce(0, Integer::sum);
    }

}

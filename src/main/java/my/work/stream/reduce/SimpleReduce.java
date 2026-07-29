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

}

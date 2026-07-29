package my.work.stream.numeric;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleStreamVsNumericStream {

    public static int sumUsingStream(List<Integer> list) {
        return list.stream().reduce(0, Integer::sum);
    }

    public static int sumUsingIntStream(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

}

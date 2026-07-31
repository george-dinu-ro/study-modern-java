package my.work.stream.terminal.summingandaveraging;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleSummingAveraging {

    public static int summingV1(List<String> input) {
        return input.stream().collect(Collectors.summingInt(String::length));
    }

    public static int summingV2(List<String> input) {
        return input.stream().mapToInt(String::length).sum();
    }

    public static double averaging(List<String> input) {
        return input.stream().collect(Collectors.averagingDouble(String::length));
    }

}

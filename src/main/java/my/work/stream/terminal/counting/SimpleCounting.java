package my.work.stream.terminal.counting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleCounting {

    public static long count(List<String> input) {
        return input.stream().collect(Collectors.counting());
    }

}

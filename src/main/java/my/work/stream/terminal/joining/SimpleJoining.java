package my.work.stream.terminal.joining;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleJoining {

    public static String simpleJoining(List<String> input) {
        return input.stream()
                .collect(Collectors.joining());
    }

    public static String delimiterJoining(List<String> input) {
        return input.stream()
                .collect(Collectors.joining(", "));
    }

    public static String enhancedJoining(List<String> input) {
        return input.stream()
                .collect(Collectors.joining(", ", "(", ")"));
    }

}

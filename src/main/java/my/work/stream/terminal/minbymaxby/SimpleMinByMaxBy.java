package my.work.stream.terminal.minbymaxby;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleMinByMaxBy {

    public static Optional<String> minBy(List<String> input) {
        return input.stream()
                .collect(Collectors.minBy(Comparator.comparing(String::length)));
    }

    public static Optional<String> min(List<String> input) {
        return input.stream()
                .min(Comparator.comparing(String::length));
    }

    public static Optional<String> maxBy(List<String> input) {
        return input.stream()
                .collect(Collectors.maxBy(Comparator.comparing(String::length)));
    }

    public static Optional<String> max(List<String> input) {
        return input.stream()
                .max(Comparator.comparing(String::length));
    }

}






package my.work.stream.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleFilter {

    private static final Predicate<String> HAS_AL_LEAST_3_CHARACTERS = s -> s.length() >= 3;

    public static List<String> filterByLength(List<String> input) {
        return input.stream()
                .filter(HAS_AL_LEAST_3_CHARACTERS)
                .toList();
    }

}

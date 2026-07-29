package my.work.stream.match;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleMatch {

    private static final Predicate<Integer> GREATER_THAN_5 = i -> i > 5;

    public static boolean matchAnyGreaterThan(List<Integer> list) {
        return list.stream()
                .anyMatch(GREATER_THAN_5);
    }

    public static boolean matchAllGreaterThan(List<Integer> list) {
        return list.stream()
                .allMatch(GREATER_THAN_5);
    }

    public static boolean matchNoneGreaterThan(List<Integer> list) {
        return list.stream()
                .noneMatch(GREATER_THAN_5);
    }

}

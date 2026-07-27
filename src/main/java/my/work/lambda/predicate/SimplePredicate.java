package my.work.lambda.predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimplePredicate {

    private static final Predicate<String> AT_LEAST_3_CHARACTERS = s -> s.length() >= 3;

    private static final Predicate<String> AT_MOST_5_CHARACTERS = s -> s.length() <= 5;

    public static boolean test(String string) {
        return AT_LEAST_3_CHARACTERS.test(string);
    }

    public static boolean testAnd(String string) {
        return AT_LEAST_3_CHARACTERS.and(AT_MOST_5_CHARACTERS).test(string);
    }

    public static boolean testOr(String string) {
        return AT_LEAST_3_CHARACTERS.or(AT_MOST_5_CHARACTERS).test(string);
    }

    public static boolean testNegate(String string) {
        return AT_LEAST_3_CHARACTERS.negate().test(string);
    }

}

package my.work.lambda.predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.BiPredicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleBiPredicate {

    private static final BiPredicate<String, String> BETWEEN_3_AND_5_CHARACTERS = (string1, string2) -> (string1.length() >= 3 && string2.length() <= 5);

    private static final BiPredicate<String, String> ONLY_LETTERS_OR_NUMBERS = (string1, string2) -> string1.matches("[a-zA-Z]+") || string2.matches("\\d+");

    public static boolean test(String string1, String string2) {
        return BETWEEN_3_AND_5_CHARACTERS.test(string1, string2);
    }

    public static boolean testAnd(String string1, String string2) {
        return BETWEEN_3_AND_5_CHARACTERS.and(ONLY_LETTERS_OR_NUMBERS).test(string1, string2);
    }

    public static boolean testOr(String string1, String string2) {
        return BETWEEN_3_AND_5_CHARACTERS.or(ONLY_LETTERS_OR_NUMBERS).test(string1, string2);
    }

    public static boolean testNegate(String string1, String string2) {
        return BETWEEN_3_AND_5_CHARACTERS.negate().test(string1, string2);
    }

}

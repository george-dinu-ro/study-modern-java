package my.work.lambda.function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleFunction {

    public static final Function<String, String> UPPER_CASE = String::toUpperCase;

    private static final Function<String, String> ADD_SUFFIX = s -> s + "end";

    public static String apply(String input) {
        return UPPER_CASE.apply(input);
    }

    public static String applyAndThen(String input) {
        return UPPER_CASE.andThen(ADD_SUFFIX).apply(input);
    }

    public static String applyCompose(String input) {
        return UPPER_CASE.compose(ADD_SUFFIX).apply(input);
    }

}

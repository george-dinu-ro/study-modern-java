package my.work.lambda.function;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleBiFunction {

    private static final BiFunction<String, String, String> CONCATENATE = String::concat;

    public static String apply(String string1, String string2) {
        return CONCATENATE.apply(string1, string2);
    }

    public static String applyAndThen(String string1, String string2) {
        return CONCATENATE.andThen(SimpleFunction.UPPER_CASE).apply(string1, string2);
    }

}

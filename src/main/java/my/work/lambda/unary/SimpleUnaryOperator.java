package my.work.lambda.unary;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.UnaryOperator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleUnaryOperator {

    private static final UnaryOperator<String> TO_UPPERCASE = String::toUpperCase;

    public static String apply(String input) {
        return TO_UPPERCASE.apply(input);
    }

}

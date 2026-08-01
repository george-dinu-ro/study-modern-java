package my.work.optional.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.lambda.predicate.SimplePredicate;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalFilterSimple {

    public static String filter(String input) {
        return Optional.ofNullable(input)
                .filter(SimplePredicate.AT_LEAST_3_CHARACTERS)
                .orElse("");
    }

}

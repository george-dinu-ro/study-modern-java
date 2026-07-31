package my.work.optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalSimple {

    public static Optional<String> ofNullable(String string) {
        return Optional.ofNullable(string);
    }

    public static Optional<String> of(String string) {
        return Optional.of(string);
    }

    public static Optional<String> empty() {
        return Optional.empty();
    }

}

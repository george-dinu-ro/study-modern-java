package my.work.optional.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalMapSimple {

    public static int map(String string) {
        return Optional.ofNullable(string)
                .map(String::length)
                .orElse(0);
    }

}


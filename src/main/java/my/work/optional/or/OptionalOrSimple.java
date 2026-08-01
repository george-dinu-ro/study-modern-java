package my.work.optional.or;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class OptionalOrSimple {

    public static String orElse(String string) {
        return Optional.ofNullable(string).orElse("default");
    }

    public static String orElseGet(String string) {
        return Optional.ofNullable(string).orElseGet(() -> "default");
    }

    public static String orElseThrow(String string) {
        return Optional.ofNullable(string).orElseThrow();
    }

    public static void orElseBehavior(String string) {
        var response = Optional.ofNullable(string).orElse(orElseMethod());
        log.info("orElse: {}", response);
    }

    public static void OrElseGetBehavior(String string) {
        var response = Optional.ofNullable(string).orElseGet(OptionalOrSimple::orElseGetMethod);
        log.info("orElseGet: {}", response);
    }

    private static String orElseMethod() {
        log.info("Inside orElse method");
        return "default";
    }

    private static String orElseGetMethod() {
        log.info("Inside orElseGet method");
        return "default";
    }

}

package my.work.optional.present;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class OptionalPresentSimple {

    public static String isPresent(String string) {
        var optional = Optional.ofNullable(string);
        return optional.isPresent() ? optional.get() : "default";
    }

    public static void ifPresent(String string) {
        Optional.ofNullable(string).ifPresent(OptionalPresentSimple::useOptional);
    }

    private static void useOptional(String string) {
        log.info("Inside useOptional method");
        log.info("value: {}", string);
    }

}

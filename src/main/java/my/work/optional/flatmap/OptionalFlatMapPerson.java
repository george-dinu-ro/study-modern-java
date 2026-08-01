package my.work.optional.flatmap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalFlatMapPerson {

    public static String getCar(Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .orElse("");
    }

}

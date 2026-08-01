package my.work.optional.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalMapPerson {

    public static String getName(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getName)
                .orElse("");
    }

}

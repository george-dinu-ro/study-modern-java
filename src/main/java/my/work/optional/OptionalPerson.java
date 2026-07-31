package my.work.optional;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalPerson {

    public static String getName(Person person) {
        var optionalPerson = Optional.ofNullable(person);
        return optionalPerson.map(Person::getName).orElse("");
    }
}

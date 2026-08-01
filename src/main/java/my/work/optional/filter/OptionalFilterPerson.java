package my.work.optional.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Optional;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalFilterPerson {
    public static Person personHasName(Person person) {
        return Optional.ofNullable(person)
                .filter(OptionalFilterPerson::hasName)
                .orElse(new Person());
    }

    private static boolean hasName(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getName)
                .filter(Predicate.not(String::isEmpty))
                .isPresent();
    }

}

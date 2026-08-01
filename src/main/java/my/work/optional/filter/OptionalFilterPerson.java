package my.work.optional.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalFilterPerson {
    public static Person filterIfHasPhones(Person person) {
        return Optional.ofNullable(person)
                .filter(OptionalFilterPerson::hasPhones)
                .orElse(new Person());
    }

    private static boolean hasPhones(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getPhones)
                .filter(Predicate.not(Collection::isEmpty))
                .isPresent();
    }

}

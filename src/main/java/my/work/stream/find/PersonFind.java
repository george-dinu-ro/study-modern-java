package my.work.stream.find;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.Optional;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFind {

    public static Optional<Person> findFirstAdult(List<Person> people) {
        return people.stream().filter(IS_ADULT).findFirst();
    }

    public static Optional<Person> findAnyAdult(List<Person> people) {
        return people.stream().filter(IS_ADULT).findAny();
    }

}

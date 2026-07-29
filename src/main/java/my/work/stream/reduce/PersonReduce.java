package my.work.stream.reduce;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonReduce {

    private static final BinaryOperator<Person> GET_OLDEST_ACCUMULATOR = (p1, p2) -> (p1.getAge() > p2.getAge()) ? p1 : p2;

    public static Optional<Person> getOldest(List<Person> people) {
        return people.stream().reduce(GET_OLDEST_ACCUMULATOR);
    }

    public static int getAdultsTotalAge(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .map(Person::getAge)
                .reduce(0, Integer::sum);
    }

}

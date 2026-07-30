package my.work.stream.terminal.counting;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.stream.Collectors;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonCounting {

    public static long countingAdults(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .collect(Collectors.counting());
    }

}

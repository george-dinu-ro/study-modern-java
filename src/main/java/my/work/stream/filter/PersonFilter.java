package my.work.stream.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFilter {

    public static List<Person> filterAdults(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .toList();
    }

}

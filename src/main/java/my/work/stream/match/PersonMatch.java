package my.work.stream.match;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMatch {

    public static boolean matchAnyIsAdult(List<Person> people) {
        return people.stream().anyMatch(IS_ADULT);
    }

    public static boolean matchAllAreAdults(List<Person> people) {
        return people.stream().allMatch(IS_ADULT);
    }

    public static boolean matchNoneIsAdult(List<Person> people) {
        return people.stream().noneMatch(IS_ADULT);
    }

}

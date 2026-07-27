package my.work.lambda.predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.lambda.Person;

import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonPredicate {

    private static final Predicate<Person> IS_ADULT = person -> person.getAge() >= 18;

    private static final Predicate<Person> HAS_PHONES = person -> !person.getPhones().isEmpty();

    public static List<Person> getAdults(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .toList();
    }

    public static List<Person> getAdultsWithPhonesWithOneFilter(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT.and(HAS_PHONES))
                .toList();
    }

    public static List<Person> getAdultsWithPhonesWithTwoFilters(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .filter(HAS_PHONES)
                .toList();
    }

}

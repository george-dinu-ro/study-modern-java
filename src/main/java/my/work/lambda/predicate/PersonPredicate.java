package my.work.lambda.predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.lambda.Person;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonPredicate {

    public static final Predicate<Person> IS_ADULT = person -> person.getAge() >= 18;

    private static final Predicate<Person> HAS_PHONES = person -> !person.getPhones().isEmpty();

    private static final BiPredicate<Person, Person> IS_ADULT_AND_HAS_PHONES = (person1, person2) -> (person1.getAge() >= 18 && !person2.getPhones().isEmpty());

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

    public static List<Person> getAdultsWithPhonesWithOneFilterBiPredicate(List<Person> people) {
        return people.stream()
                .filter(person -> IS_ADULT_AND_HAS_PHONES.test(person, person))
                .toList();
    }

    public static List<Person> getAdultsWithPhonesWithTwoFilters(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .filter(HAS_PHONES)
                .toList();
    }

}

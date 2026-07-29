package my.work.stream.filter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFilter {

    public static final Predicate<Person> IS_ADULT = person -> person.getAge() >= 18;

    public static List<Person> filterAdults(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .toList();
    }

}

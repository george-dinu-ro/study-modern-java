package my.work.stream.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMap {

    public static List<String> getNames(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .toList();
    }

    public static List<Person> getPeopleOrderedByNameAsc(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .toList();
    }

    public static List<Person> getPeopleOrderedByAgeDesc(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .toList();
    }

}

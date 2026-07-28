package my.work.stream.flatmap;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonFlatMap {

    public static List<String> getPhonesV1(List<Person> people) {
        return people.stream()
                .flatMap(person -> person.getPhones().stream())
                .toList();
    }

    public static List<String> getPhonesV2(List<Person> people) {
        return people.stream()
                .map(Person::getPhones)
                .flatMap(Collection::stream)
                .toList();
    }

}

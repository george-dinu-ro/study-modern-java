package my.work.stream.map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMap {

    public static List<String> getNames(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .toList();
    }

}

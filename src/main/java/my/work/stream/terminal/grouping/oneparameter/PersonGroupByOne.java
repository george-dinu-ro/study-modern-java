package my.work.stream.terminal.grouping.oneparameter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonGroupByOne {

    public static String ageLabel(Person person) {
        return person.getAge() >= 18 ? "ADULT" : "MINOR";
    }

    public static Map<String, List<Person>> groupingByStatus(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getStatus));
    }

    public static Map<String, List<Person>> groupingByAge(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(PersonGroupByOne::ageLabel));
    }

}

package my.work.stream.terminal.grouping.twoparameters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;
import my.work.stream.terminal.grouping.oneparameter.PersonGroupByOne;
import my.work.stream.terminal.summingaveraging.PersonSummingAveraging;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonGroupByTwo {

    public static Map<String, Map<String, List<Person>>> groupingByAgeAndStatus(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(PersonGroupByOne::ageLabel,
                                Collectors.groupingBy(Person::getStatus)));
    }

    public static Map<String, Integer> groupingByStatus(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(Person::getStatus,
                                Collectors.summingInt(PersonSummingAveraging::getNumberOfPhones)));
    }

}

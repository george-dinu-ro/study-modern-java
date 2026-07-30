package my.work.stream.terminal.summingaveraging;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonSummingAveraging {

    public static int getNumberOfPhones(Person person) {
        return person.getPhones().size();
    }

    public static int totalNumberOfPhones(List<Person> people) {
        return people.stream()
                .collect(Collectors.summingInt(PersonSummingAveraging::getNumberOfPhones));
    }

    public static double averageNumberOfPhones(List<Person> people) {
        return people.stream()
                .collect(Collectors.averagingDouble(PersonSummingAveraging::getNumberOfPhones));
    }

}

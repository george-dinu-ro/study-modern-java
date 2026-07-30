package my.work.stream.terminal.joining;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonJoining {

    public static String getNames(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.joining(", ", "(", ")"));
    }

}

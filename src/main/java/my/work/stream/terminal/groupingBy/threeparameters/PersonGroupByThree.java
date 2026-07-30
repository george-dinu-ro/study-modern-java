package my.work.stream.terminal.groupingBy.threeparameters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonGroupByThree {

    public static Map<String, Set<Person>> groupingByStatus(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getStatus,
                        LinkedHashMap::new,
                        Collectors.toSet()));
    }

}

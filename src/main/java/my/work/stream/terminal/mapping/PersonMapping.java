package my.work.stream.terminal.mapping;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.List;
import java.util.stream.Collectors;

import static my.work.lambda.predicate.PersonPredicate.IS_ADULT;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonMapping {

    public static List<String> mappingAdults(List<Person> people) {
        return people.stream()
                .filter(IS_ADULT)
                .collect(Collectors.mapping(Person::getName, Collectors.toList()));
    }

}

package my.work.stream.terminal.grouping.twoparameters.sort;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import my.work.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonGroupByTwoWithDescOrder {

    public static Map<String, Optional<Person>> groupingByStatusOrderByAgeDescOptional(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getStatus,
                                Collectors.maxBy(Comparator.comparingInt(Person::getAge))));
    }

    public static Map<String, Person> groupingByStatusOrderByAgeDescV1(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getStatus,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparing(Person::getAge)),
                                        Optional::get)));
    }

    public static Map<String, Person> groupingByStatusOrderByAgeDescV2(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.toMap(
                                Person::getStatus,
                                Function.identity(),
                                BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));
    }

}

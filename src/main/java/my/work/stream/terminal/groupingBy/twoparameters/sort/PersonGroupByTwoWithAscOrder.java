package my.work.stream.terminal.groupingBy.twoparameters.sort;

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
public class PersonGroupByTwoWithAscOrder {

    public static Map<String, Optional<Person>> groupingByStatusOrderByAgeAscOptional(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getStatus,
                                Collectors.minBy(Comparator.comparing(Person::getAge))));
    }

    public static Map<String, Person> groupingByStatusOrderByAgeAscV1(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getStatus,
                                Collectors.collectingAndThen(
                                        Collectors.minBy(
                                                Comparator.comparing(Person::getAge)),
                                        Optional::get)));
    }

    public static Map<String, Person> groupingByStatusOrderByAgeAscV2(List<Person> people) {
        return people.stream()
                .collect(
                        Collectors.toMap(
                                Person::getStatus,
                                Function.identity(),
                                BinaryOperator.minBy(Comparator.comparing(Person::getAge))));
    }

}

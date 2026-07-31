package my.work.stream.terminal.groupingBy.twoparameters.sort;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonGroupByTwoWithAscOrderTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatusOrderByAgeAscOptional_thenGroupByStatus(List<Person> people) {
        var expected = Map.of(
                "high-school",
                Optional.of(
                        Person.builder()
                                .name("Bob B.")
                                .age(16)
                                .status("high-school")
                                .phones(Collections.emptyList())
                                .build()),
                "student",
                Optional.of(Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build()),
                "employee",
                Optional.of(
                        Person.builder()
                                .name("Dan D.")
                                .age(25)
                                .status("employee")
                                .phones(List.of("*21", "*22"))
                                .build()));

        var actual = PersonGroupByTwoWithAscOrder.groupingByStatusOrderByAgeAscOptional(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatusOrderByAgeAscV1_thenGroupByStatus(List<Person> people) {
        var expected = Map.of(
                "high-school",
                Person.builder()
                        .name("Bob B.")
                        .age(16)
                        .status("high-school")
                        .phones(Collections.emptyList())
                        .build(),
                "student",
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                "employee",
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .status("employee")
                        .phones(List.of("*21", "*22"))
                        .build());

        var actual = PersonGroupByTwoWithAscOrder.groupingByStatusOrderByAgeAscV1(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatusOrderByAgeAscV2_thenGroupByStatus(List<Person> people) {
        var expected = Map.of(
                "high-school",
                Person.builder()
                        .name("Bob B.")
                        .age(16)
                        .status("high-school")
                        .phones(Collections.emptyList())
                        .build(),
                "student",
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                "employee",
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .status("employee")
                        .phones(List.of("*21", "*22"))
                        .build());

        var actual = PersonGroupByTwoWithAscOrder.groupingByStatusOrderByAgeAscV2(people);

        assertEquals(expected, actual);
    }

}
package my.work.stream.terminal.grouping.twoparameters.sort;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonGroupByTwoWithDescOrderTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatusOrderByAgeDescOptional_thenGroupByStatus(List<Person> people) {
        var expected = Map.of(
                "high-school",
                Optional.of(
                        Person.builder()
                                .name("Eugen E.")
                                .age(17)
                                .status("high-school")
                                .phones(List.of("*51"))
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
                                .name("Marry M.")
                                .age(32)
                                .status("employee")
                                .phones(List.of("*31"))
                                .build()));

        var actual = PersonGroupByTwoWithDescOrder.groupingByStatusOrderByAgeDescOptional(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatusOrderByAgeDescV1_thenGroupByStatus(List<Person> people) {
        var expected = Map.of(
                "high-school",
                Person.builder()
                        .name("Eugen E.")
                        .age(17)
                        .status("high-school")
                        .phones(List.of("*51"))
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
                        .name("Marry M.")
                        .age(32)
                        .status("employee")
                        .phones(List.of("*31"))
                        .build());

        var actual = PersonGroupByTwoWithDescOrder.groupingByStatusOrderByAgeDescV1(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatusOrderByAgeDescV2_thenGroupByStatus(List<Person> people) {
        var expected = Map.of(
                "high-school",
                Person.builder()
                        .name("Eugen E.")
                        .age(17)
                        .status("high-school")
                        .phones(List.of("*51"))
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
                        .name("Marry M.")
                        .age(32)
                        .status("employee")
                        .phones(List.of("*31"))
                        .build());

        var actual = PersonGroupByTwoWithDescOrder.groupingByStatusOrderByAgeDescV2(people);

        assertEquals(expected, actual);
    }

}
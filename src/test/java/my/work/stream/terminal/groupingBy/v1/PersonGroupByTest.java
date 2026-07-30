package my.work.stream.terminal.groupingBy.v1;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonGroupByTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByStatus_thenUseDefaultGrouping(List<Person> people) {
        var expected = Map.of(
                "high-school",
                List.of(
                        Person.builder()
                                .name("Eugen E.")
                                .age(17)
                                .status("high-school")
                                .phones(List.of("*51"))
                                .build(),
                        Person.builder()
                                .name("Bob B.")
                                .age(16)
                                .status("high-school")
                                .phones(Collections.emptyList())
                                .build()),
                "student",
                List.of(Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build()),
                "employee",
                List.of(
                        Person.builder()
                                .name("Dan D.")
                                .age(25)
                                .status("employee")
                                .phones(List.of("*21", "*22"))
                                .build(),
                        Person.builder()
                                .name("Marry M.")
                                .age(32)
                                .status("employee")
                                .phones(List.of("*31"))
                                .build(),
                        Person.builder()
                                .name("Nick N.")
                                .age(27)
                                .status("employee")
                                .phones(List.of("*41", "*42"))
                                .build(),
                        Person.builder()
                                .name("Larry L.")
                                .age(30)
                                .status("employee")
                                .phones(Collections.emptyList())
                                .build()));

        var actual = PersonGroupBy.groupingByStatus(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGroupingByAge_thenUseCustomGrouping(List<Person> people) {
        var expected = Map.of(
                "MINOR",
                List.of(
                        Person.builder()
                                .name("Eugen E.")
                                .age(17)
                                .status("high-school")
                                .phones(List.of("*51"))
                                .build(),
                        Person.builder()
                                .name("Bob B.")
                                .age(16)
                                .status("high-school")
                                .phones(Collections.emptyList())
                                .build()),
                "ADULT",
                List.of(
                        Person.builder()
                                .name("John J.")
                                .age(20)
                                .status("student")
                                .phones(List.of("*10", "*11", "*12"))
                                .build(),
                        Person.builder()
                                .name("Dan D.")
                                .age(25)
                                .status("employee")
                                .phones(List.of("*21", "*22"))
                                .build(),
                        Person.builder()
                                .name("Marry M.")
                                .age(32)
                                .status("employee")
                                .phones(List.of("*31"))
                                .build(),
                        Person.builder()
                                .name("Nick N.")
                                .age(27)
                                .status("employee")
                                .phones(List.of("*41", "*42"))
                                .build(),
                        Person.builder()
                                .name("Larry L.")
                                .age(30)
                                .status("employee")
                                .phones(Collections.emptyList())
                                .build()));

        var actual = PersonGroupBy.groupingByAge(people);

        assertEquals(expected, actual);
    }

}
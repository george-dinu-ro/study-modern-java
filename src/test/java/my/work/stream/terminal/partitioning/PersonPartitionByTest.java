package my.work.stream.terminal.partitioning;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonPartitionByTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallPartitioningByAgeDefault_thenUsePartitioningBy(List<Person> people) {
        var expected = Map.of(
                Boolean.FALSE,
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
                Boolean.TRUE,
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

        var actual = PersonPartitionBy.partitioningByAgeDefault(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallPartitioningByAgeUsingSet_thenUsePartitioningByWithCollector(List<Person> people) {
        var expected = Map.of(
                Boolean.FALSE,
                Set.of(
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
                Boolean.TRUE,
                Set.of(
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

        var actual = PersonPartitionBy.partitioningByAgeUsingSet(people);

        assertEquals(expected, actual);
    }

}
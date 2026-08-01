package my.work.interfacee.defaultt;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DefaultMethodPersonTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallCompareByName_thenUseNameComparator(List<Person> input) {
        var expected = List.of(
                Person.builder()
                        .name("Bob B.")
                        .age(16)
                        .status("high-school")
                        .phones(Collections.emptyList())
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .status("employee")
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Eugen E.")
                        .age(17)
                        .status("high-school")
                        .phones(List.of("*51"))
                        .build(),
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Larry L.")
                        .age(30)
                        .status("employee")
                        .phones(Collections.emptyList())
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
                        .build());

        input = new ArrayList<>(input);
        var actual = DefaultMethodPerson.compareByName(input);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallCompareByNUmberOfPhones_thenUseNumberOfPhonesComparator(List<Person> input) {
        var expected = List.of(
                Person.builder()
                        .name("Larry L.")
                        .age(30)
                        .status("employee")
                        .phones(Collections.emptyList())
                        .build(),
                Person.builder()
                        .name("Bob B.")
                        .age(16)
                        .status("high-school")
                        .phones(Collections.emptyList())
                        .build(),
                Person.builder()
                        .name("Marry M.")
                        .age(32)
                        .status("employee")
                        .phones(List.of("*31"))
                        .build(),
                Person.builder()
                        .name("Eugen E.")
                        .age(17)
                        .status("high-school")
                        .phones(List.of("*51"))
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .status("employee")
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Nick N.")
                        .age(27)
                        .status("employee")
                        .phones(List.of("*41", "*42"))
                        .build(),
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build());

        input = new ArrayList<>(input);
        var actual = DefaultMethodPerson.compareByNumberOfPhones(input);

        assertIterableEquals(expected, actual);
    }


    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallCompareByNameAndNumberOfPhones_thenUseTwoComparators(List<Person> input) {
        var expected = List.of(
                Person.builder()
                        .name("Bob B.")
                        .age(16)
                        .status("high-school")
                        .phones(Collections.emptyList())
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .status("employee")
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Eugen E.")
                        .age(17)
                        .status("high-school")
                        .phones(List.of("*51"))
                        .build(),
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .status("student")
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Larry L.")
                        .age(30)
                        .status("employee")
                        .phones(Collections.emptyList())
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
                        .build());

        input = new ArrayList<>(input);
        var actual = DefaultMethodPerson.compareByNameAndNumberOfPhones(input);

        assertIterableEquals(expected, actual);
    }

}
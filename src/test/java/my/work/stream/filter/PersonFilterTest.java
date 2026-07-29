package my.work.stream.filter;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PersonFilterTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallFilterAdults_thenCallFilter(List<Person> people) {
        var expected = List.of(
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Marry M.")
                        .age(30)
                        .phones(List.of("*31"))
                        .build(),
                Person.builder()
                        .name("Nick N.")
                        .age(27)
                        .phones(List.of("*41", "*42"))
                        .build(),
                Person.builder()
                        .name("Larry L.")
                        .age(30)
                        .phones(Collections.emptyList())
                        .build());

        var actual = PersonFilter.filterAdults(people);

        assertIterableEquals(expected, actual);
    }

}
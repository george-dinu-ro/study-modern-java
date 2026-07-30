package my.work.stream.terminal.minbymaxby;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonMinByMaxByTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallMinByAge_thenGetYoungestPerson(List<Person> people) {
        var expected = Optional.of(Person.builder()
                .name("Bob B.")
                .age(16)
                .phones(Collections.emptyList())
                .build());

        var actual = PersonMinByMaxBy.minByAge(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallMaxByAge_thenGetOldestPerson(List<Person> people) {
        var expected = Optional.of(Person.builder()
                .name("Marry M.")
                .age(32)
                .phones(List.of("*31"))
                .build());

        var actual = PersonMinByMaxBy.maxByAge(people);

        assertEquals(expected, actual);
    }

}
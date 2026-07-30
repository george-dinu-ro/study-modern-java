package my.work.stream.find;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonFindTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallFindFirstAdult_thenUseFindFirst(List<Person> people) {
        var expected = Optional.of(Person.builder()
                .name("John J.")
                .age(20)
                .status("student")
                .phones(List.of("*10", "*11", "*12"))
                .build());
        var actual = PersonFind.findFirstAdult(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallFindAnyAdult_thenUseFindAny(List<Person> people) {
        var expected = Optional.of(Person.builder()
                .name("John J.")
                .age(20)
                .status("student")
                .phones(List.of("*10", "*11", "*12"))
                .build());
        var actual = PersonFind.findAnyAdult(people);

        assertEquals(expected, actual);
    }


}
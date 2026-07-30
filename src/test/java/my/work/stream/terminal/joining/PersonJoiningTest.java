package my.work.stream.terminal.joining;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonJoiningTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetNames_thenUseJoining(List<Person> people) {
        var expected = "(John J., Dan D., Marry M., Nick N., Eugen E., Larry L., Bob B.)";
        var actual = PersonJoining.getNames(people);

        assertEquals(expected, actual);
    }

}
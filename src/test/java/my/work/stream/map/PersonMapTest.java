package my.work.stream.map;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PersonMapTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetNames_thenCallMap(List<Person> people) {
        var expected = List.of("John J.", "Dan D.", "Marry M.", "Nick N.", "Eugen E.", "Larry L.", "Bob B.");
        var actual = PersonMap.getNames(people);

        assertIterableEquals(expected, actual);
    }

}
package my.work.stream.terminal.mapping;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PersonMappingTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallMappingAdults_thenUseFilterAndMapping(List<Person> people) {
        var expected = List.of("John J.", "Dan D.", "Marry M.", "Nick N.", "Larry L.");
        var actual = PersonMapping.mappingAdults(people);

        assertIterableEquals(expected, actual);
    }

}
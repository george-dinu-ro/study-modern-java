package my.work.stream.reduce;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonReduceTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetOldest_thenGetOldestPerson(List<Person> people) {
        var expected = Person.builder()
                .name("Marry M.")
                .age(32)
                .status("employee")
                .phones(List.of("*31"))
                .build();

        var actual = PersonReduce.getOldest(people);

        assertTrue(actual.isPresent());

        assertEquals(expected, actual.get());
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetAdultsTotalAge_thenDoSum(List<Person> people) {
        var actual = PersonReduce.getAdultsTotalAge(people);

        assertEquals(134, actual);
    }

}
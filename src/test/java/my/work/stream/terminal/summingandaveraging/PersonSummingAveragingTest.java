package my.work.stream.terminal.summingandaveraging;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonSummingAveragingTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallTotalNumberOfPhones_thenUseSummingInt(List<Person> people) {
        var expected = 9;
        var actual = PersonSummingAveraging.totalNumberOfPhones(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallAverageNumberOfPhones_thenUseAveragingDouble(List<Person> people) {
        var expected = 1.28D;
        var actual = PersonSummingAveraging.averageNumberOfPhones(people);

        assertEquals(expected, actual, 0.006);
    }

}
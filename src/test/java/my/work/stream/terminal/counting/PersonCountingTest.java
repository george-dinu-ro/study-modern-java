package my.work.stream.terminal.counting;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonCountingTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallCountingAdults_thenUseFilterAndCounting(List<Person> people) {
        var expected = 5L;
        var actual = PersonCounting.countingAdults(people);

        assertEquals(expected, actual);
    }

}
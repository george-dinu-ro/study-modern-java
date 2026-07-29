package my.work.stream.match;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonMatchTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallMatchAnyIsAdult_thenUseMatchAny(List<Person> people) {
        var actual = PersonMatch.matchAnyIsAdult(people);

        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallMatchAllAreAdults_thenUseMatchAll(List<Person> people) {
        var actual = PersonMatch.matchAllAreAdults(people);

        assertFalse(actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallMatchNoneIsAdult_thenUseMatchNone(List<Person> people) {
        var actual = PersonMatch.matchNoneIsAdult(people);

        assertFalse(actual);
    }

}
package my.work.lambda.function;

import my.work.lambda.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonFunctionTest {

    @ParameterizedTest
    @MethodSource("my.work.lambda.PersonStorage#getPeople")
    void whenCallGetPeopleWithPhonesCount_thenCallOneFunction(List<Person> people) {
        var expected = Map.of(
                "John J.", 3,
                "Dan D.", 2,
                "Marry M.", 1,
                "Nick N.", 2,
                "Eugen E.", 1,
                "Larry L.", 0,
                "Bob B.", 0);

        var actual = PersonFunction.getPeopleWithPhonesCount(people);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.lambda.PersonStorage#getPeople")
    void whenCallGetAdultsWithPhonesCount_thenCallOneFunctionAndOnePredicate(List<Person> people) {
        var expected = Map.of(
                "John J.", 3,
                "Dan D.", 2,
                "Marry M.", 1,
                "Nick N.", 2,
                "Larry L.", 0);

        var actual = PersonFunction.getAdultsWithPhonesCount(people);

        assertEquals(expected, actual);
    }

}
package my.work.stream.flatmap;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PersonFlatMapTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetPhonesV1_thenCallFlatMap(List<Person> people) {
        var expected = getExpectedPhones();
        var actual = PersonFlatMap.getPhonesV1(people);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetPhonesV2_thenCallFlatMap(List<Person> people) {
        var expected = getExpectedPhones();
        var actual = PersonFlatMap.getPhonesV2(people);

        assertIterableEquals(expected, actual);
    }

    private static List<String> getExpectedPhones() {
        return List.of("*10", "*11", "*12", "*21", "*22", "*31", "*41", "*42", "*51");
    }

}
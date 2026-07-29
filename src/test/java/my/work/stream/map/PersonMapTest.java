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

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetPeopleOrderedByNameAsc_thenCallMapAndSortByName(List<Person> people) {
        var expected = List.of("Bob B.", "Dan D.", "Eugen E.", "John J.", "Larry L.", "Marry M.", "Nick N.");
        var actual = PersonMap.getPeopleOrderedByNameAsc(people);
        var names = actual.stream().map(Person::getName).toList();

        assertIterableEquals(expected, names);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetPeopleOrderedByAgeDesc_thenCallMapAndSortByAgeDesc(List<Person> people) {
        var expected = List.of(32, 30, 27, 25, 20, 17, 16);
        var actual = PersonMap.getPeopleOrderedByAgeDesc(people);
        var ages = actual.stream().map(Person::getAge).toList();

        assertIterableEquals(expected, ages);
    }


}
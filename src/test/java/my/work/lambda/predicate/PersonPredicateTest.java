package my.work.lambda.predicate;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class PersonPredicateTest {

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetAdults_thenCallOnePredicate(List<Person> people) {
        var expected = List.of(
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Marry M.")
                        .age(30)
                        .phones(List.of("*31"))
                        .build(),
                Person.builder()
                        .name("Nick N.")
                        .age(27)
                        .phones(List.of("*41", "*42"))
                        .build(),
                Person.builder()
                        .name("Larry L.")
                        .age(30)
                        .phones(Collections.emptyList())
                        .build());

        var actual = PersonPredicate.getAdults(people);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetAdultsWithOneFilter_thenCallOneFilterWithTwoPredicates(List<Person> people) {
        var expected = List.of(
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Marry M.")
                        .age(30)
                        .phones(List.of("*31"))
                        .build(),
                Person.builder()
                        .name("Nick N.")
                        .age(27)
                        .phones(List.of("*41", "*42"))
                        .build());

        var actual = PersonPredicate.getAdultsWithPhonesWithOneFilter(people);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetAdultsWithOneFilterBiPredicate_thenCallOneFilterWithOneBiPredicate(List<Person> people) {
        var expected = List.of(
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Marry M.")
                        .age(30)
                        .phones(List.of("*31"))
                        .build(),
                Person.builder()
                        .name("Nick N.")
                        .age(27)
                        .phones(List.of("*41", "*42"))
                        .build());

        var actual = PersonPredicate.getAdultsWithPhonesWithOneFilterBiPredicate(people);

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("my.work.PersonStorage#getPeople")
    void whenCallGetAdultsWithTwoFilters_thenCallTwoFiltersWithTwoPredicates(List<Person> people) {
        var expected = List.of(
                Person.builder()
                        .name("John J.")
                        .age(20)
                        .phones(List.of("*10", "*11", "*12"))
                        .build(),
                Person.builder()
                        .name("Dan D.")
                        .age(25)
                        .phones(List.of("*21", "*22"))
                        .build(),
                Person.builder()
                        .name("Marry M.")
                        .age(30)
                        .phones(List.of("*31"))
                        .build(),
                Person.builder()
                        .name("Nick N.")
                        .age(27)
                        .phones(List.of("*41", "*42"))
                        .build());

        var actual = PersonPredicate.getAdultsWithPhonesWithTwoFilters(people);

        assertIterableEquals(expected, actual);
    }

}
package my.work.optional.filter;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalFilterPersonTest {

    @ParameterizedTest
    @MethodSource("initFilter")
    void whenCallFilterIfHasPhones_thenUseFilter(Person input, Person expected) {
        var actual = OptionalFilterPerson.filterIfHasPhones(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initFilter() {
        return Stream.of(
                Arguments.of(
                        null,
                        new Person()),
                Arguments.of(
                        new Person(),
                        new Person()
                ),
                Arguments.of(
                        Person.builder()
                                .phones(null)
                                .build(),
                        new Person()),
                Arguments.of(
                        Person.builder()
                                .phones(List.of("*10"))
                                .build(),
                        Person.builder()
                                .phones(List.of("*10"))
                                .build()));
    }

}
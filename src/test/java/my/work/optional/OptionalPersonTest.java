package my.work.optional;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalPersonTest {

    @ParameterizedTest
    @MethodSource("initGetName")
    void whenCallGetName_thenUseOptional(Person person, String expected) {
        var actual = OptionalPerson.getName(person);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initGetName() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(Person.builder().build(), ""),
                Arguments.of(Person.builder().name("Danny D.").build(), "Danny D."));
    }

}
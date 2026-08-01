package my.work.optional.map;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalMapPersonTest {

    @ParameterizedTest
    @MethodSource("initGetName")
    void whenCallGetName_thenUseMap(Person input, String expected) {
        var actual = OptionalMapPerson.getName(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initGetName() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(new Person(), ""),
                Arguments.of(Person.builder().name("").build(), ""),
                Arguments.of(Person.builder().name("Jim J.").build(), "Jim J."));
    }

}
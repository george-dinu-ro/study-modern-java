package my.work.optional.flatmap;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionalFlatMapPersonTest {

    @ParameterizedTest
    @MethodSource("initGetCar")
    void whenCallGetCarWithFlatMap_thenUseFlatMap(Person input, String expected) {
        var actual = OptionalFlatMapPerson.getCar(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initGetCar() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(new Person(), ""),
                Arguments.of(Person.builder().car(Optional.of("volvo")).build(), "volvo"));
    }

}
package my.work.stream.find;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleFindTest {

    @ParameterizedTest
    @MethodSource("initFind")
    void whenCallFindFirst_useFindFirst(List<String> input, Optional<String> expected) {
        var actual = SimpleFind.findFirst(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initFind")
    void whenCallFindAny_useFindAny(List<String> input, Optional<String> expected) {
        var actual = SimpleFind.findAny(input);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> initFind() {
        return Stream.of(
                Arguments.of(List.of("a", "b", "c"), Optional.of("a")));
    }

}
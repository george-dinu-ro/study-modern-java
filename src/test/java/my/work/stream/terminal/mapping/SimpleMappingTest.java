package my.work.stream.terminal.mapping;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SimpleMappingTest {

    @ParameterizedTest
    @MethodSource("initMapping")
    void whenCallMapping_thenUseMapping(List<String> input, List<String> expected) {
        var actual = SimpleMapping.mapping(input);

        assertIterableEquals(expected, actual);
    }

    private static Stream<Arguments> initMapping() {
        return Stream.of(
                Arguments.of(
                        List.of("a", "b", "c"),
                        List.of("A", "B", "C")));
    }

}
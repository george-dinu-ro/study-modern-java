package my.work.stream.factory;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SimpleFactoryTest {

    @ParameterizedTest
    @MethodSource("initStream")
    void whenCallOf_thenUseOf(List<String> expected) {
        var actual = SimpleFactory.of().toList();

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initStream")
    void whenCallIterate_thenUseIterate(List<String> expected) {
        var actual = SimpleFactory.iterate().toList();

        assertIterableEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("initStream")
    void whenCallGenerate_thenUseGenerate(List<String> expected) {
        var actual = SimpleFactory.generate().toList();

        assertIterableEquals(expected, actual);
    }

    private static Stream<Arguments> initStream() {
        return Stream.of(
                Arguments.of(List.of("a", "b", "c", "d", "e")));
    }

}
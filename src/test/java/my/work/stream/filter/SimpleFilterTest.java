package my.work.stream.filter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SimpleFilterTest {

    @ParameterizedTest
    @MethodSource("filterInit")
    void whenCallFilterByLength_thenUseFilter(List<String> input, List<String> expected) {
        var actual = SimpleFilter.filterByLength(input);

        assertIterableEquals(expected, actual);
    }

    public static Stream<Arguments> filterInit() {
        return Stream.of(
                Arguments.of(
                        List.of("a", "aa", "aaa", "aaaa", "aaaaa"),
                        List.of("aaa", "aaaa", "aaaaa")));
    }
}
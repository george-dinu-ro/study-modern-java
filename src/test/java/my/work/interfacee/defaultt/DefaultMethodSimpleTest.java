package my.work.interfacee.defaultt;

import my.work.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class DefaultMethodSimpleTest {

    @ParameterizedTest
    @MethodSource("initList")
    void whenCallSortUsingCollections_thenUseCollections(List<String> input, List<Person> expected) {
        DefaultMethodSimple.sortUsingCollections(input);

        assertIterableEquals(input, expected);
    }

    @ParameterizedTest
    @MethodSource("initList")
    void whenCallSortUsingDefaultMethod_thenUseDefaultMethod(List<String> input, List<Person> expected) {
        DefaultMethodSimple.sortUsingDefaultMethod(input);

        assertIterableEquals(input, expected);
    }

    @ParameterizedTest
    @MethodSource("initNullSafeList")
    void whenCallSortUsingNullSafeDefaultMethod_thenUseNullSafeDefaultMethod(List<String> input, List<Person> expected) {
        DefaultMethodSimple.sortUsingNullSafeDefaultMethod(input);

        assertIterableEquals(input, expected);
    }

    private static Stream<Arguments> initList() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(List.of("b", "c", "a")),
                        List.of("a", "b", "c")));
    }

    private static Stream<Arguments> initNullSafeList() {
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(Arrays.asList("b", null, "c", "a", null)),
                        new ArrayList<>(Arrays.asList(null, null, "a", "b", "c"))));
    }

}
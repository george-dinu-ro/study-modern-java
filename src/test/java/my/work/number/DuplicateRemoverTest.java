package my.work.number;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DuplicateRemoverTest {

    @ParameterizedTest
    @MethodSource("testData")
    void whenCallRemoveDuplicatesImperative_thenGetListWithDuplicatesRemoved(List<Integer> input, List<Integer> expected, List<Integer> unExpected) {
        var actual = DuplicateRemover.removeDuplicatesImperative(input);

        assertEquals(expected, actual);
        assertNotEquals(unExpected, actual);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void whenCallRemoveDuplicatesEnhancedImperative_thenGetListWithDuplicatesRemoved(List<Integer> input, List<Integer> expected, List<Integer> unExpected) {
        var actual = DuplicateRemover.removeDuplicatesEnhancedImperative(input);

        assertEquals(expected, actual);
        assertNotEquals(unExpected, actual);
    }

    @ParameterizedTest
    @MethodSource("testData")
    void whenCallRemoveDuplicatesDeclarative_thenGetListWithDuplicatesRemoved(List<Integer> input, List<Integer> expected, List<Integer> unExpected) {
        var actual = DuplicateRemover.removeDuplicatesDeclarative(input);

        assertEquals(expected, actual);
        assertNotEquals(unExpected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 1, 4, 1, 3, 5, 4, 5),
                        List.of(1, 2, 3, 4, 5),
                        List.of(1, 2, 3, 4, 5, 6)
                ));
    }

}
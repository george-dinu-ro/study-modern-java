package my.work.lambda.predicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleBiPredicateTest {

    @ParameterizedTest
    @CsvSource({
            "a, false",
            "abc, true",
            "abcde, true",
            "abcdef, false"
    })
    void whenCallTest_thenCallOneBiPredicate(String input, boolean expected) {
        var actual = SimpleBiPredicate.test(input, input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, false",
            "a1 b, false",
            "abc, true",
            "123, true",
            "12 3, false",
            "abc1, false",
            "ab12, false",
            "abc 1, false",
            "abcde, true",
            "abc de, false",
            "abcdef, false"
    })
    void whenCallTestAnd_thenCallTwoBiPredicates(String input, boolean expected) {
        var actual = SimpleBiPredicate.testAnd(input, input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, true",
            "a1 b, true",
            "abc, true",
            "123, true",
            "12 3, true",
            "abc1, true",
            "ab12, true",
            "abc 1, true",
            "abcde, true",
            "abc de, false",
            "abcdef, true",
            "abcdef, true",
            "123 45, false",
    })
    void whenCallTestOr_thenCallTwoBiPredicates(String input, boolean expected) {
        var actual = SimpleBiPredicate.testOr(input, input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, true",
            "abc, false",
            "abcde, false",
            "abcdef, true"
    })
    void whenCallTestNegate_thenCallOneBiPredicate(String input, boolean expected) {
        var actual = SimpleBiPredicate.testNegate(input, input);

        assertEquals(expected, actual);
    }
}
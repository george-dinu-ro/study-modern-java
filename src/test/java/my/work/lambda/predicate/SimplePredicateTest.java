package my.work.lambda.predicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimplePredicateTest {

    @ParameterizedTest
    @CsvSource({
            "a, false",
            "abc, true",
            "abcd, true"
    })
    void whenCallTest_thenCallOnePredicate(String input, boolean expected) {
        var actual = SimplePredicate.test(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, false",
            "abc, true",
            "abcde, true",
            "abcdef, false"
    })
    void whenCallTestAnd_thenCallTwoPredicates(String input, boolean expected) {
        var actual = SimplePredicate.testAnd(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, true",
            "abc, true",
            "abcde, true",
            "abcdef, true"
    })
    void whenCallTestOr_thenCallTwoPredicates(String input, boolean expected) {
        var actual = SimplePredicate.testOr(input);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "a, true",
            "abc, false",
            "abcd, false"
    })
    void whenCallTestNegate_thenCallOnePredicate(String input, boolean expected) {
        var actual = SimplePredicate.testNegate(input);

        assertEquals(expected, actual);
    }

}
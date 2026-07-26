package my.work.sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SumCalculatorTest {

    @Test
    void whenCallGetImperativeSum_thenShouldReturnSum() {
        var actual = SumCalculator.getImperativeSum(10);

        assertEquals(55, actual);
        assertNotEquals(54, actual);
    }

    @Test
    void whenCallGetDeclarativeSum_thenShouldReturnSum() {
        var actual = SumCalculator.getDeclarativeSum(10);

        assertEquals(55, actual);
        assertNotEquals(54, actual);
    }

}
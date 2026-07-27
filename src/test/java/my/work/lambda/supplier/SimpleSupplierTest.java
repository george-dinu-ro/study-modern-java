package my.work.lambda.supplier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SimpleSupplierTest {

    @Test
    void whenCallNextInt_thenCallSupplier() {
        var actual = SimpleSupplier.nextInt();

        assertNotNull(actual);
    }

}
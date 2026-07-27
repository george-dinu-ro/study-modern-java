package my.work.lambda.supplier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonSupplierTest {

    @Test
    void whenCallGet_thenCallSupplier() {
        var actual = PersonSupplier.get();

        assertNotNull(actual);
    }

}
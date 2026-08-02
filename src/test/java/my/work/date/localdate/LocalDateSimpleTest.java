package my.work.date.localdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalDateSimpleTest {

    private static LocalDateSimple localDateSimple;

    @BeforeEach
    void init() {
        localDateSimple = new LocalDateSimple();
    }

    @Test
    void testGetLocalDate() {
        var localDate = localDateSimple.getLocalDate();
        System.out.println(localDate.toString());
    }

}
package my.work.date.localdatetime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalDateTimeSimpleTest {

    private static LocalDateTimeSimple localDateTimeSimple;

    @BeforeEach
    void init() {
        localDateTimeSimple = new LocalDateTimeSimple();
    }

    @Test
    void testGetLocalDateTime() {
        var localDateTime = localDateTimeSimple.getLocalDateTime();
        System.out.println(localDateTime);
    }

}
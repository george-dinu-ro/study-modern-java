package my.work.date.localtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalTimeSimpleTest {

    private static LocalTimeSimple localTimeSimple;

    @BeforeEach
    void init() {
        localTimeSimple = new LocalTimeSimple();
    }

    @Test
    void testGetLocalTime() {
        var localTime = localTimeSimple.getLocalTime();
        System.out.println(localTime);
    }

}
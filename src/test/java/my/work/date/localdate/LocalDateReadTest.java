package my.work.date.localdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LocalDateReadTest {

    private static LocalDateRead localDateRead;

    @BeforeEach
    void init() {
        localDateRead = new LocalDateRead();
    }

    @Test
    void testNow() {
        var localDate = localDateRead.now();
        System.out.println(localDate);
    }

    @Test
    void testOf() {
        var localDate = localDateRead.of(2026, 8, 2);
        System.out.println(localDate);
    }

    @Test
    void testOfYearDay() {
        var localDate = localDateRead.ofYearDay(2026, 214);
        System.out.println(localDate);
    }

    @Test
    void testGetMonth() {
        var month = localDateRead.getMonth(LocalDate.now());
        System.out.println(month);
    }

    @Test
    void testGetMonthValue() {
        var monthValue = localDateRead.getMonthValue(LocalDate.now());
        System.out.println(monthValue);
    }

    @Test
    void testGetDayOfWeek() {
        var dayOfWeek = localDateRead.getDayOfWeek(LocalDate.now());
        System.out.println(dayOfWeek);
    }

    @Test
    void testGetDayOfMonth() {
        var dayOfMonth = localDateRead.getDayOfMonth(LocalDate.now());
        System.out.println(dayOfMonth);
    }

    @Test
    void testGetDayOfMonthWithChronoField() {
        var dayOfMonth = localDateRead.getDayOfMonthWithChronoField(LocalDate.now());
        System.out.println(dayOfMonth);
    }

    @Test
    void testGetDayOfYear() {
        var dayOfYear = localDateRead.getDayOfYear(LocalDate.now());
        System.out.println(dayOfYear);
    }

}
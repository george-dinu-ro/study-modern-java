package my.work.date.localdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LocalDateSimpleTest {

    private static LocalDateSimple localDateSimple;

    @BeforeEach
    void init() {
        localDateSimple = new LocalDateSimple();
    }

    @Test
    void testNow() {
        var localDate = localDateSimple.now();
        System.out.println(localDate);
    }

    @Test
    void testOf() {
        var localDate = localDateSimple.of(2026, 8, 2);
        System.out.println(localDate);
    }

    @Test
    void testOfYearDay() {
        var localDate = localDateSimple.ofYearDay(2026, 214);
        System.out.println(localDate);
    }

    @Test
    void testGetMonth() {
        var month = localDateSimple.getMonth(LocalDate.now());
        System.out.println(month);
    }

    @Test
    void testGetMonthValue() {
        var monthValue = localDateSimple.getMonthValue(LocalDate.now());
        System.out.println(monthValue);
    }

    @Test
    void testGetDayOfWeek() {
        var dayOfWeek = localDateSimple.getDayOfWeek(LocalDate.now());
        System.out.println(dayOfWeek);
    }

    @Test
    void testGetDayOfMonth() {
        var dayOfMonth = localDateSimple.getDayOfMonth(LocalDate.now());
        System.out.println(dayOfMonth);
    }

    @Test
    void testGetDayOfMonthWithChronoField() {
        var dayOfMonth = localDateSimple.getDayOfMonthWithChronoField(LocalDate.now());
        System.out.println(dayOfMonth);
    }

    @Test
    void testGetDayOfYear() {
        var dayOfYear = localDateSimple.getDayOfYear(LocalDate.now());
        System.out.println(dayOfYear);
    }

}
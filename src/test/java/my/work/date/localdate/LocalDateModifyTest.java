package my.work.date.localdate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class LocalDateModifyTest {

    private static LocalDateModify localDateModify;

    @BeforeEach
    void init() {
        localDateModify = new LocalDateModify();
    }

    @Test
    void testPlusDays() {
        var localDate = localDateModify.plusDays(LocalDate.now(), 10);
        System.out.println(localDate);
    }

    @Test
    void testMinusDays() {
        var localDate = localDateModify.minusDays(LocalDate.now(), 10);
        System.out.println(localDate);
    }

    @Test
    void testPlusMonths() {
        var localDate = localDateModify.plusMonths(LocalDate.now(), 2);
        System.out.println(localDate);
    }

    @Test
    void testWithYear() {
        var localDate = localDateModify.withYear(LocalDate.now(), 2000);
        System.out.println(localDate);
    }

    @Test
    void testWithYearWithChronoField() {
        var localDate = localDateModify.withYearWithChronoField(LocalDate.now(), 2000);
        System.out.println(localDate);
    }

    @Test
    void testMinusYearWithChronoUnit() {
        var localDate = localDateModify.minusYearWithChronoUnit(LocalDate.now(), 1);
        System.out.println(localDate);
    }

    @Test
    void testWithTemporalAdjusters() {
        var localDate = localDateModify.withTemporalAdjusters(LocalDate.now());
        System.out.println(localDate);
    }

}
package my.work.date.localdate;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateModify {

    public LocalDate plusDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    public LocalDate minusDays(LocalDate date, int days) {
        return date.minusDays(days);
    }

    public LocalDate plusMonths(LocalDate date, int months) {
        return date.plusMonths(months);
    }

    public LocalDate withYear(LocalDate date, int year) {
        return date.withYear(year);
    }

    public LocalDate withYearWithChronoField(LocalDate date, int year) {
        return date.with(ChronoField.YEAR, year);
    }

    public LocalDate minusYearWithChronoUnit(LocalDate date, int amountToSubtract) {
        return date.minus(amountToSubtract, ChronoUnit.YEARS);
    }

    public LocalDate withTemporalAdjusters(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

}

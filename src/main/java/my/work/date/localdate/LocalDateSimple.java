package my.work.date.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateSimple {

    public LocalDate now() {
        return LocalDate.now();
    }

    public LocalDate of(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public LocalDate ofYearDay(int year, int dayOfYear) {
        return LocalDate.ofYearDay(year, dayOfYear);
    }

    public Month getMonth(LocalDate date) {
        return date.getMonth();
    }

    public int getMonthValue(LocalDate date) {
        return date.getMonthValue();
    }

    public DayOfWeek getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek();
    }

    public int getDayOfMonth(LocalDate date) {
        return date.getDayOfMonth();
    }

    public int getDayOfMonthWithChronoField(LocalDate date) {
        return date.get(ChronoField.DAY_OF_MONTH);
    }

    public int getDayOfYear(LocalDate date) {
        return date.getDayOfYear();
    }

}

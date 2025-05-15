package src.main.java.com.example.shuuhoumaker.model.provider;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateProvider {
    public static List<LocalDate> getThisWeekDates() {
        List<LocalDate> dates = new ArrayList<>();
        LocalDate startDay = LocalDate.now().with(DayOfWeek.SUNDAY).minusDays(7);
        for (int i = 0; i < 7; i++) {
            LocalDate date = startDay.plusDays(i);
            dates.add(date);
        }
        return dates;
    }

    public static List<LocalDate> getWeekDates(int weekOffset) {
        LocalDate start = LocalDate.now()
                .with(DayOfWeek.SUNDAY).minusDays(7)
                .plusWeeks(weekOffset);
        List<LocalDate> weekDates = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            weekDates.add(start.plusDays(i));
        }
        return weekDates;
    }
}

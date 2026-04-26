package src.main.java.com.example.shuuhoumaker.factory;

import src.main.java.com.example.shuuhoumaker.model.data.DayData;
import src.main.java.com.example.shuuhoumaker.model.data.Status;
import src.main.java.com.example.shuuhoumaker.provider.DateProvider;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeekDataFactory {
    public static List<DayData> create(int weekOffset){
        List<LocalDate> dates = DateProvider.getWeekDates(weekOffset);
        List<DayData> dataList = new ArrayList<>();

        for (LocalDate date : dates) {
            Status defaultStatus = isWeekendOrHoliday(date) ? Status.HOLIDAY : Status.WORKDAY;
            dataList.add(new DayData(date, 18, 30, defaultStatus));
        }

        return dataList;
    }

    private static boolean isWeekendOrHoliday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}

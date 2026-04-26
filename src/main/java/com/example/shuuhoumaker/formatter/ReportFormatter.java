package src.main.java.com.example.shuuhoumaker.formatter;

import src.main.java.com.example.shuuhoumaker.model.data.DayData;
import src.main.java.com.example.shuuhoumaker.provider.TemplateProvider;

import java.util.List;

public class ReportFormatter {
    public static String format(List<String> works, List<DayData> thisWeek, List<DayData> nextWeek) {
        String thisWeekSummary = DayDataFormatter.formatSummary(thisWeek);
        String nextWeekSummery = DayDataFormatter.formatSummary(nextWeek);
        String titleDate = DayDataFormatter.formatTitleDay(thisWeek.get(0));
        String targetDays = DayDataFormatter.formatTargetDays(thisWeek);
        return TemplateProvider.formatTemplate(works, thisWeekSummary, nextWeekSummery, titleDate, targetDays);
    }
}

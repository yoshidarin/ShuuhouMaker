package src.main.java.com.example.shuuhoumaker.model.formatter;

import src.main.java.com.example.shuuhoumaker.model.data.DayData;
import src.main.java.com.example.shuuhoumaker.model.data.Status;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DayDataFormatter {
    public static String formatSummary(List<DayData> resultData){
        List<String> lines = new ArrayList<>();
        for (DayData day : resultData) {
            String line;
            if (day.getStatus() == Status.WORKDAY) {
                line = String.format("%s 09:30 ~ %02d:%02d  通常勤務",
                        day.getDate().format(DateTimeFormatter.ofPattern("MM月dd日(E)")), day.getHour(), day.getMinute());
            } else {
                line = String.format("%s %s",
                        day.getDate().format(DateTimeFormatter.ofPattern("MM月dd日(E)")), day.getStatus().getLabel());
            }
            lines.add(line);
        }
        String weekSummary = String.join("\n", lines);
        return weekSummary;
    }

    public static String formatTargetDays(List<DayData> resultData){

        return String.format("%s〜%s",
                resultData.get(0).getDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)")),
                resultData.get(resultData.size()-1).getDate().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日(E)"))
        );

    }

    public static String formatTitleDay(DayData data){
        return  data.getDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}

package src.main.java.com.example.shuuhoumaker.model.provider;

import src.main.java.com.example.shuuhoumaker.model.data.DayData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TemplateProvider {

    private static final String TEMPLATE = getTemplate();
    public static String getTemplate() {
        try (InputStream is = TemplateProvider.class.getResourceAsStream("/template.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String generate(List<DayData> dataList) {
        StringBuilder builder = new StringBuilder();
        for (DayData data : dataList) {
            builder.append(String.format(
                    "%s %02d:%02d %s\n",
                    data.getDate().format(DateTimeFormatter.ofPattern("M/d(E)")),
                    data.getHour(),
                    data.getMinute(),
                    data.getStatus().getLabel()
            ));
        }
        return builder.toString();
    }

    // 選択された作業リストを渡すと、埋め込んだ完成文を返す
    public static String formatTemplate(List<String> selectedItems,String weekSummary,String nextWeekSummary, String titleDate, String targetDays) {
        String joinedWorks = String.join("\n", selectedItems);
        return MessageFormat.format(TEMPLATE, titleDate, targetDays, weekSummary, joinedWorks, nextWeekSummary);
    }
}

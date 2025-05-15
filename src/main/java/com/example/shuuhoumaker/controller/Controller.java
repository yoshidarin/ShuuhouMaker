package src.main.java.com.example.shuuhoumaker.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import src.main.java.com.example.shuuhoumaker.view.*;
import src.main.java.com.example.shuuhoumaker.model.data.*;
import src.main.java.com.example.shuuhoumaker.model.provider.*;
import src.main.java.com.example.shuuhoumaker.model.formatter.*;




public class Controller {
        private MainFrame mainFrame;
        private ResultFrame resultFrame;

    public void startApp() {
        // 必要なデータ取得
        List<String> workList = WorkListProvider.getAllWorks();

        // Viewの初期化
        mainFrame = new MainFrame(this, workList);  // Controllerとデータを渡す
        mainFrame.setVisible(true);
    }

    // ボタン押下時の処理
    public void handleSubmit(List<String> selectedItems, List<DayData> resultData) {
        // ここでModel更新や別画面へ遷移を行う
        // System.out.println("選択された項目: " + selectedItems);

        String thisWeekSummary = DayDataFormatter.formatSummary(resultData);
        String nextWeekSummery = DayDataFormatter.formatSummary(createWeekData(1));
        String titleDate = DayDataFormatter.formatTitleDay(resultData.get(0));
        String targetDays = DayDataFormatter.formatTargetDays(resultData);
        String result = TemplateProvider.formatTemplate(selectedItems, thisWeekSummary,nextWeekSummery, titleDate, targetDays);
        resultFrame = new ResultFrame(this, result);
        resultFrame.setVisible(true);

    }

    // weekPanelようのデータ作り
    public List<DayData> createWeekData(int weekOffset) {
        List<LocalDate> dates = DateProvider.getWeekDates(weekOffset);
        List<DayData> dataList = new ArrayList<>();

        for (LocalDate date : dates) {
            Status defaultStatus = isWeekendOrHoliday(date) ? Status.HOLIDAY : Status.WORKDAY;
            dataList.add(new DayData(date, 18, 30, defaultStatus));
        }

        return dataList;
    }

    // 土日判定
    public boolean isWeekendOrHoliday(LocalDate date){
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        } else {
            return false;
        }
    }
    

}
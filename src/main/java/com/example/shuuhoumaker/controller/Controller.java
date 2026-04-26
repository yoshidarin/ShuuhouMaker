package src.main.java.com.example.shuuhoumaker.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import src.main.java.com.example.shuuhoumaker.factory.WeekDataFactory;
import src.main.java.com.example.shuuhoumaker.view.*;
import src.main.java.com.example.shuuhoumaker.model.data.*;
import src.main.java.com.example.shuuhoumaker.provider.*;
import src.main.java.com.example.shuuhoumaker.formatter.*;

public class Controller {
        private MainFrame mainFrame;
        private ResultFrame resultFrame;

    public void startApp() {
        // 必要なデータ取得
        List<String> workList = WorkListProvider.getAllWorks();
        List<DayData> thisWeekData = WeekDataFactory.create(0);
        List<DayData> lastWeekData = WeekDataFactory.create(-1);

        // Viewの初期化
        mainFrame = new MainFrame(this, workList, thisWeekData, lastWeekData);  // Controllerとデータを渡す
        mainFrame.setVisible(true);
    }

    // ボタン押下時の処理
    public void handleSubmit(List<String> selectedItems, List<DayData> resultData, int weekOffset) {
        // ここでModel更新や別画面へ遷移を行う
        // System.out.println("選択された項目: " + selectedItems);
        // 来週の週データ取得　
        List<DayData> nextWeek = WeekDataFactory.create(weekOffset + 1);
        String result = ReportFormatter.format(selectedItems, resultData,nextWeek);
        resultFrame = new ResultFrame(result);
        resultFrame.setVisible(true);

    }

}
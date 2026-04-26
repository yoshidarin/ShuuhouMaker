package src.main.java.com.example.shuuhoumaker.view;

import src.main.java.com.example.shuuhoumaker.controller.Controller;
import src.main.java.com.example.shuuhoumaker.model.data.DayData;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TabPanel  extends JPanel{

    private JButton submitButton;
    

    public TabPanel(List<String> workList, Controller controller, int weekOffset){

        setLayout(new BorderLayout(10, 10));
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        submitButton = new JButton("送信");
        submitPanel.add(submitButton);
        add(submitPanel, BorderLayout.SOUTH);
        List<DayData> weekData = controller.createWeekData(weekOffset);
        WeekPanel weekPanel = new WeekPanel(weekData);
        add(weekPanel,BorderLayout.NORTH);

        // workDataのチェックボックス
        WorkCheckBoxPanel  workContentPanel = new WorkCheckBoxPanel(workList);

            // イベントリスナーを設定
            submitButton.addActionListener(e -> {
                // チェック状態を取得
                List<String> selected = workContentPanel.getSelectedWorks();
                List<DayData> resultData = weekPanel.getAllDayData();
                controller.handleSubmit(selected, resultData, weekOffset);

            });

        add(workContentPanel, BorderLayout.CENTER);

    }
    
}

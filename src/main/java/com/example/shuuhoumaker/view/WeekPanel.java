package src.main.java.com.example.shuuhoumaker.view;

import src.main.java.com.example.shuuhoumaker.model.data.DayData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WeekPanel extends JPanel {
    private List<DayPanel> dayPanels;

    public WeekPanel(List<DayData> weekData) {
        setLayout(new GridLayout(7, 1));
        dayPanels = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            DayPanel dayPanel = new DayPanel(weekData.get(i));
            dayPanels.add(dayPanel);
            add(dayPanel);
        }
    }

    public List<DayData> getAllDayData() {
        List<DayData> result = new ArrayList<>();
        for (DayPanel panel : dayPanels) {
            result.add(panel.getDayData());
        }
        return result;
    }
}

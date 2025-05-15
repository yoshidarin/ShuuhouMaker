package src.main.java.com.example.shuuhoumaker.view;

import src.main.java.com.example.shuuhoumaker.model.data.DayData;
import src.main.java.com.example.shuuhoumaker.model.data.Status;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class DayPanel extends JPanel {
    private JLabel dateLabel;
    private JComboBox<Integer> hourCombo;
    private JComboBox<Integer> minuteCombo;
    private  JComboBox<Status> statusCombo;
    private DayData dayData;

    public DayPanel(DayData data) {
        this.dayData =data;
        this.dateLabel = new JLabel(data.getDate().format(DateTimeFormatter.ofPattern("MM月dd日(E)")));
        this.hourCombo = new JComboBox<>(generateHourOptions());
        this.minuteCombo = new JComboBox<>(generateMinuteOptions());
        this.statusCombo = new JComboBox<>(Status.values());
        // statusComboは日本語ラベルで表示
        statusCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Status) {
                    setText(((Status) value).getLabel());
                }
                return this;
            }
        });
        // 初期値設定
        hourCombo.setSelectedItem(data.getHour());
        minuteCombo.setSelectedItem(data.getMinute());
        statusCombo.setSelectedItem(data.getStatus());

        add(dateLabel);
        setLayout(new FlowLayout());
        add(hourCombo);
        add(new JLabel(":"));
        add(minuteCombo);
        add(statusCombo);
    }

    private Integer[] generateHourOptions() {
        Integer[] hours = new Integer[16];
        for (int i = 0; i < 16; i++) {
            hours[i] = i+8;
        }
        return hours;
    }

    private Integer[] generateMinuteOptions() {
        return new Integer[]{0, 15, 30, 45};
    }

    public Integer getSelectedHour() {
        return (Integer) hourCombo.getSelectedItem();
    }

    public Integer getSelectedMinute() {
        return  (Integer) minuteCombo.getSelectedItem();
    }

    public DayData getDayData() {
        dayData.setHour((Integer) hourCombo.getSelectedItem());
        dayData.setMinute((Integer) minuteCombo.getSelectedItem());
        dayData.setStatus((Status) statusCombo.getSelectedItem());
        return dayData;
    }
}

package src.main.java.com.example.shuuhoumaker.view;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkCheckBoxPanel extends JPanel {

    private Map<String, JCheckBox> workCheckboxes = new LinkedHashMap<>();

    public WorkCheckBoxPanel(List<String> works) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String work : works) {
            JCheckBox box = new JCheckBox(work);
            workCheckboxes.put(work, box);
            add(box);
        }
    }

    public List<String> getSelectedWorks() {
        return workCheckboxes.entrySet().stream()
            .filter(entry -> entry.getValue().isSelected())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    
}

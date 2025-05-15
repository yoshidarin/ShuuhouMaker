package src.main.java.com.example.shuuhoumaker.view;

import src.main.java.com.example.shuuhoumaker.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {
    public ResultPanel(String result, ResultFrame resultFrame, Controller controller){
        setLayout(new BorderLayout(10, 10));
        JTextArea resultTextArea = new JTextArea(result);
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }
}

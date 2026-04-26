package src.main.java.com.example.shuuhoumaker.view;


import src.main.java.com.example.shuuhoumaker.controller.Controller;
import src.main.java.com.example.shuuhoumaker.model.data.DayData;

import javax.swing.*;
import java.util.List;


public class MainFrame extends JFrame{
    private JTabbedPane tabbedPane;
    private List<String> workList;
    public MainFrame(Controller controller, List<String> workList, List<DayData> thisWeekData, List<DayData> lastWeekData) {
        setTitle("週報メーカー");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.workList = workList;
        // タブ付きペインの設定
        initComponents(controller, thisWeekData, lastWeekData);
    }
    
    private void initComponents(Controller controller, List<DayData> thisWeekData, List<DayData> lastWeekData) {
        tabbedPane = new JTabbedPane();
        
        // 各タブパネルを作成
        TabPanel firstTab = new TabPanel(workList, controller,thisWeekData, 0);
        TabPanel secondTab = new TabPanel(workList, controller,lastWeekData, -1);
        
        // タブを追加
        tabbedPane.addTab("今週", firstTab);
        tabbedPane.addTab("先週", secondTab);
        
        getContentPane().add(tabbedPane);
    }

}

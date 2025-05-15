package src.main.java.com.example.shuuhoumaker.view;


import src.main.java.com.example.shuuhoumaker.controller.Controller;
import src.main.java.com.example.shuuhoumaker.model.data.WorkDataModel;

import javax.swing.*;
import java.util.List;


public class MainFrame extends JFrame{
    private JTabbedPane tabbedPane;
    private WorkDataModel dataModel;
    List<String> workList;
    public MainFrame(Controller controller, List<String> workList) {
        setTitle("週報メーカー");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.workList = workList;
        // タブ付きペインの設定
        initComponents(controller);
    }
    
    private void initComponents(Controller controller) {
        tabbedPane = new JTabbedPane();
        
        // 各タブパネルを作成
        TabPanel firstTab = new TabPanel(workList, this, controller);
        TabPanel secondTab = new TabPanel(workList, this, controller);
        
        // タブを追加
        tabbedPane.addTab("今週", firstTab);
        tabbedPane.addTab("タブ2", secondTab);
        
        getContentPane().add(tabbedPane);
    }
    /*
    // 画面遷移を処理するメソッド
    public void navigateToDetailWindow(String data) {
        // 現在のフレームを非表示に
        setVisible(false);
        
        // 新しい画面を表示
        DetailWindow detailWindow = new DetailWindow(this, dataModel);
        detailWindow.setData(data);
        detailWindow.setVisible(true);
    }
    */
    
    // メインフレームに戻るメソッド
    public void returnToMainFrame() {
        setVisible(true);
    }

   
}

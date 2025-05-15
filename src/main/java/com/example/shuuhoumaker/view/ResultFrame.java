package src.main.java.com.example.shuuhoumaker.view;


import src.main.java.com.example.shuuhoumaker.controller.Controller;
import src.main.java.com.example.shuuhoumaker.model.data.WorkDataModel;

import javax.swing.*;


public class ResultFrame extends JFrame{
    private JTabbedPane tabbedPane;
    private WorkDataModel dataModel;
    String result;
    public ResultFrame(Controller controller, String result) {
        setTitle("今週の週報出力画面");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.result = result;
        // タブ付きペインの設定
        initComponents(result, controller);
    }
    
    private void initComponents(String result, Controller controller) {

        // 結果パネルを作る
        ResultPanel resultPanel = new ResultPanel(result, this, controller);
        add(resultPanel);
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

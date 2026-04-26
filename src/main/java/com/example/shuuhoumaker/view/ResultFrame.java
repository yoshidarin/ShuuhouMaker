package src.main.java.com.example.shuuhoumaker.view;

import src.main.java.com.example.shuuhoumaker.controller.Controller;
import javax.swing.*;

public class ResultFrame extends JFrame{
    String result;
    public ResultFrame(String result) {
        setTitle("今週の週報出力画面");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //ResultFrameのみとじる
        setLocationRelativeTo(null);
        this.result = result;
        // タブ付きペインの設定
        initComponents(result);
    }
    
    private void initComponents(String result) {

        // 結果パネルを作る
        ResultPanel resultPanel = new ResultPanel(result);
        add(resultPanel);
    }

}

package src.main.java.com.example.shuuhoumaker;

import src.main.java.com.example.shuuhoumaker.controller.Controller;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Controller controller = new Controller();
            controller.startApp(); // アプリ開始
        });


    }    
    
}

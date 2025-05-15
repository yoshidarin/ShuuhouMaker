package src.main.java.com.example.shuuhoumaker.model.data;

import java.time.LocalDate;

public class DayData {
    private LocalDate date;
    private int hour;
    private int minute;
    private Status status; // 通常勤務、休日、有給休暇
    // コンストラクタ
    public DayData(LocalDate date, int hour, int minute, Status status){
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.status = status;
    }
    public DayData(){
        // 空のコンストラクタ（特に処理なし）
    }
    // getter/setter
    public LocalDate getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public Status getStatus() {
        return status;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

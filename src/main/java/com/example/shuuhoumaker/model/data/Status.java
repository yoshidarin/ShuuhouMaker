package src.main.java.com.example.shuuhoumaker.model.data;

public enum Status {
    WORKDAY("通常勤務"),
    HOLIDAY("休日"),
    VACATION("有給休暇");
    private final String label; // 日本語ラベルを持たせる

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


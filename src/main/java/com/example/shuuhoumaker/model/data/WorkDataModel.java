package src.main.java.com.example.shuuhoumaker.model.data;

import java.util.ArrayList;
import java.util.List;

public class WorkDataModel {

   private List<String> selectedWorks = new ArrayList<>();

    public void setSelectedWorks(List<String> works) {
        this.selectedWorks = works;
    }

    public List<String> getSelectedHobbies() {
        return selectedWorks;
    }
}

    


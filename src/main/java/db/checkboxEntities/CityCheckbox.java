package db.checkboxEntities;

import db.entities.City;
import javafx.scene.control.CheckBox;

public class CityCheckbox {
    private CheckBox checkBox;
    private City city;
    public CityCheckbox(City city) {
        checkBox = new CheckBox();
        this.city=city;
    }

    public void setCheckBox(Boolean check) {
        checkBox.setSelected(check);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public String getCity() {
        return city.getCity();
    }

    public int getId() {
        return city.getId();
    }
}

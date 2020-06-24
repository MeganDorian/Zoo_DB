package db.entities;

import javafx.scene.control.CheckBox;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name="cities", schema = "public")
public class City {
    @Id
    //@Column(name = "id_city")
    private int id_city;

    @Column
    private String city;

    public String getCity() {
        return city;
    }

    public int getId() {
        return id_city;
    }
}

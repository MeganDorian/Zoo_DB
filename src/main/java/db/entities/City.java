package db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="zoo_db", schema = "public")
public class City {
    @Id
    //@Column(name = "id_city")
    private int id_city;

    @Column
    private String city;

}

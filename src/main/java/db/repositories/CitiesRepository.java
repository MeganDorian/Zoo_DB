package db.repositories;

import db.entities.City;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {
    Optional<City> findById(Integer id);

    @Override
    List<City> findAll();
}

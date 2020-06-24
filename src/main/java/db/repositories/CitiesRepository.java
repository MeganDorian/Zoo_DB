package db.repositories;

import db.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CitiesRepository extends JpaRepository<City, Integer> {
    Optional<City> findById(Integer id);
}

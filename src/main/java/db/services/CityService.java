package db.services;

import db.entities.City;
import db.repositories.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CitiesRepository citiesRepository;

    public Optional<City> findCityById_city(int id) {
        return citiesRepository.findById (id);
    }
}

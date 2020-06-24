package db.services;

import db.checkboxEntities.CityCheckbox;
import db.entities.City;
import db.exceptions.Exceptions;
import db.repositories.CitiesRepository;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CitiesRepository citiesRepository;

    public CityCheckbox findCityById(int id) throws UnsupportedEncodingException {
        Optional<City> city= citiesRepository.findById (id);
        if (city.isPresent())
            return new CityCheckbox(city.get());
        else
            Exceptions.sendAlert(Alert.AlertType.INFORMATION, "Поиск города",
                    String.format("Город с %d id не найден",id));
        return null;
    }

    public List<CityCheckbox> findAllCities() {
        List<City> allCities= citiesRepository.findAll();
        List<CityCheckbox> cityCheckboxList = new ArrayList<>();
        for(City city:allCities)
            cityCheckboxList.add(new CityCheckbox(city));
        return cityCheckboxList;
    }
}

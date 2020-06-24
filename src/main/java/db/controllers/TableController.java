package db.controllers;

import db.checkboxEntities.CityCheckbox;
import db.convertation.ConvertCharsets;
import db.entities.City;
import db.services.CityService;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.List;

public class TableController {
    private static boolean check;

    @Autowired
    private String numColumn;

    @Autowired
    private Environment properties;

    @Autowired
    private IntegerProperty intP;

    private String currentTable;
    @FXML
    private Menu refBooks;

    @FXML
    private Pagination pagination;

    @Autowired
    private CityService cityService;

    private ApplicationContext context;

    public void setContext(ApplicationContext context) {
        this.context=context;
    }

    private int rowsPerPage() {
        return intP.get();
    }

    private void addCheckBox(TableView table) {
        switch (currentTable) {
            case "cities":
                TableColumn<City, Boolean> tableColumn = new TableColumn<>();
                tableColumn.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
                table.getColumns().add(tableColumn);
                break;
        }

    }

    private VBox createPage(int pageIndex, List data) {
        int lastIndex;
        int displace = data.size() % rowsPerPage();
        if (displace > 0)
            lastIndex=data.size()/rowsPerPage();
        else
            lastIndex=data.size()/rowsPerPage()-1;
        VBox box = new VBox();
        for (int i = pageIndex; i < pageIndex + 1; i++) {
            switch(currentTable) {
                case "cities":
                    TableView<City> table = new TableView<>();
                    addCheckBox(table);
                    TableColumn number = new TableColumn(numColumn);
                    number.setCellValueFactory(new PropertyValueFactory<City, Integer>("id"));

                    String cityName=properties.getProperty("cities.city");
                    TableColumn city = new TableColumn(ConvertCharsets.ConvertISO_8859_1(cityName));
                    city.setCellValueFactory(new PropertyValueFactory<City, String>("city"));

                    table.getColumns().addAll(number,city);
                    if (lastIndex==pageIndex)
                        table.setItems(FXCollections.observableArrayList(data.subList(
                                pageIndex*rowsPerPage(),pageIndex*rowsPerPage()+displace)));
                    else
                        table.setItems(FXCollections.observableArrayList(data.subList(
                                pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + rowsPerPage())));
                    box.getChildren().add(table);
                    break;
            }
        }
        return box;
    }

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void initData() {
        currentTable="cities";
        /*CityCheckbox city = null;
        try {
            city = cityService.findCityById(2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List <CityCheckbox> cities = new ArrayList<CityCheckbox>();
        cities.add(city);*/
        List <CityCheckbox> cities = cityService.findAllCities();
        if (!cities.isEmpty())
            pagination.setPageCount(cities.size()/rowsPerPage()+1);
        pagination.setPageFactory(integer -> {
            if (integer > cities.size()/rowsPerPage()+1)
                return null;
            else
                return createPage(integer,cities);
        });
    }

    public void action() {

    }
    public void animalsAction() {

    }

    public void staffAction() {
    }

    public void medicalAidsAction() {
    }

    public void zooAction() {
    }

    public void exitAction() {
    }

    public void motherlandsAction() {
    }

    public void classesAction() {
    }

    public void speciesAction() {
    }

    public void jobsAction() {
    }

    public void helpTypesAction() {
    }

    public void citiesAction() {

    }

    public void propertyTypesAction() {
    }
}

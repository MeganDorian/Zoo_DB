import db.services.CityService;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
@Component
public class TableController {
    public Menu refBooks;
    @Autowired
    private CityService cityService;

    private ApplicationContext context;

    public void setContext(ApplicationContext context) {
        this.context=context;
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

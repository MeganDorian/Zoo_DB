package db;

import db.controllers.ControllersConfiguration;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TableMain extends AbstractJavaFxApplicationSupport {

    @Qualifier("tableView")
    @Autowired
    private ControllersConfiguration.View view;

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(view.getView()));
        stage.centerOnScreen();
        stage.show();
    }
}

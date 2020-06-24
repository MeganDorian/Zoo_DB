import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import db.services.CityService;
import db.Spring;

import java.io.UnsupportedEncodingException;

import static exceptions.Exceptions.sendAlert;

@Component
public class Controller {
    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {

    }

    @Autowired
    private CityService cityService;

    public void auth() {
        try {
            if (login.getText().length() == 0)
                sendAlert(Alert.AlertType.ERROR, "Ошибка при авторизации", "Введите логин");
            else if (password.getText().length() == 0)
                sendAlert(Alert.AlertType.ERROR, "Ошибка при авторизации", "Введите пароль");
            else {
                //Spring.username=login.getText();
                //Spring.password=password.getText();
                ApplicationContext context = SpringApplication.run(Spring.class);
                Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                TableMain main = new TableMain();
                try {
                    main.start(stage, context);
                } catch (java.lang.Exception e) {
                    sendAlert(Alert.AlertType.ERROR, "Ошибка", "Ошибка при открытии главного меню");
                    e.printStackTrace();
                }
            }
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
}

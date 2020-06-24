package db.controllers;//import db.Spring;
import db.TableMain;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

import static db.exceptions.Exceptions.sendAlert;

public class Controller {

    @Autowired
    private TableMain table;
    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {

    }

    public void auth() {
        try {
            if (login.getText().length() == 0)
                sendAlert(Alert.AlertType.ERROR, "Ошибка при авторизации", "Введите логин");
            else if (password.getText().length() == 0)
                sendAlert(Alert.AlertType.ERROR, "Ошибка при авторизации", "Введите пароль");
            else {
                Stage stage = (Stage) login.getScene().getWindow();
                stage.close();
                try {
                    table.start(stage);
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

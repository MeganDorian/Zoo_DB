package db.exceptions;

import db.convertation.ConvertCharsets;
import javafx.scene.control.Alert;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Exceptions {
    public static void sendAlert(Alert.AlertType alertType, String title, String text) throws UnsupportedEncodingException {
        Alert alert = new Alert(alertType);
        alert.setTitle(ConvertCharsets.ConvertWindows_1251(title));
        alert.setHeaderText(null);
        alert.setContentText(ConvertCharsets.ConvertWindows_1251(text));
        alert.showAndWait();
    }
}

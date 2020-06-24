package exceptions;

import javafx.scene.control.Alert;

import java.io.UnsupportedEncodingException;

public class Exceptions {
    public static void sendAlert(Alert.AlertType alertType, String title, String text) throws UnsupportedEncodingException {
        Alert alert = new Alert(alertType);
        alert.setTitle(new String (title.getBytes(), "windows-1251"));
        alert.setHeaderText(null);
        alert.setContentText(new String (text.getBytes(), "windows-1251"));
        alert.showAndWait();
    }
}

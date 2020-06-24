import exceptions.Exceptions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class TableMain {
    public void start(Stage window, ApplicationContext context) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/table.fxml"));
        Parent root = loader.load();
        TableController tableController = loader.getController();
        tableController.setContext(context);
        window.setScene(new Scene(root, 800, 600));
        window.setOnCloseRequest(windowEvent -> {
            SpringApplication.exit(context);
            Stage stage =(Stage) window.getScene().getWindow();
            stage.close();
            Main main = new Main();
            try {
                main.start(new Stage());
            } catch (IOException e) {
                try {
                    Exceptions.sendAlert(Alert.AlertType.ERROR, "Ошибка", "Ошибка при закрытии главного меню");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        });
        window.show();
    }

}

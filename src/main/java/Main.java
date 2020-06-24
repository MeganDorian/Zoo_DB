import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("fxml/login.fxml"));
        String title ="Авторизация";
        primaryStage.setTitle(new String (title.getBytes("windows-1251"), StandardCharsets.UTF_8));
        primaryStage.setScene(new Scene(root, 280, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
        //SpringApplication.exit(context);
    }

}
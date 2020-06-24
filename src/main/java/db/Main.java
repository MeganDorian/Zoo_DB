package db;

import db.controllers.ControllersConfiguration;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

@Lazy
@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    @Qualifier("loginView")
    @Autowired
    private ControllersConfiguration.View view;

    @Override
    public void start(Stage stage) {
        stage.setScene(new Scene(view.getView()));
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(Main.class, args);
    }
}
/*
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

}*/

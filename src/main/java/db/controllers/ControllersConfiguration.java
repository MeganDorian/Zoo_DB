package db.controllers;

import db.controllers.Controller;
import db.controllers.TableController;
import db.convertation.ConvertCharsets;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Configuration
public class ControllersConfiguration {
    @Bean
    public String numColumn() throws UnsupportedEncodingException {
        return ConvertCharsets.ConvertWindows_1251("№");
    }

    @Bean
    public IntegerProperty intNum() {
        return new SimpleIntegerProperty(40);
    }

    @Bean (name="loginView")
    public View getLoginView() throws IOException {
        return loadView("fxml/login.fxml");
    }

    @Bean
    public Controller getLoginController() throws IOException {
        return (Controller)getLoginView().getController();
    }

    @Bean(name="tableView")
    public View getTableView() throws IOException {
        return loadView("fxml/table.fxml");
    }

    @Bean
    public TableController getTableController() throws IOException {
        return (TableController)getTableView().getController();
    }

    protected View loadView(String url) throws IOException {
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(url)) {
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new View(loader.getRoot(), loader.getController());
        }
    }

    public class View {
        private Parent view;
        private Object controller;

        public View(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }
}

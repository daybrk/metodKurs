package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
//    public static AnchorPane root;

    @Override
    public void start(Stage stage) throws IOException {
        addScene("mainFrame.fxml", 600, 1000);

    }

    public static void addScene(String name, int h, int w) throws IOException {
        Parent root = FXMLLoader.load(App.class.getResource(name));
        Stage stage = new Stage();
        stage.setTitle("Нечаев Илья БИМ 18-01");
        stage.setScene(new Scene(root, w, h));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
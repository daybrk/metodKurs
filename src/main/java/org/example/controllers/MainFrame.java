package org.example.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.example.App;

public class MainFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> selectedItemTable;

    @FXML
    private TableView<?> allItemTable;

    @FXML
    private Button createPlanBut;

    @FXML
    private Button addItemBut;

    @FXML
    void initialize() {

        createPlanBut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    App.addScene("createPlan.fxml", 500, 1000);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

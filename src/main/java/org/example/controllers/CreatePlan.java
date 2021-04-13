package org.example.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;

public class CreatePlan {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> planTable;

    @FXML
    private MenuButton menuBrigade;

    @FXML
    private ListView<?> listOfInstruments;

    @FXML
    void initialize() {

    }
}

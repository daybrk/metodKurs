package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.entities.Equipment;

public class CreatePlan {

    @FXML
    private TableView<Equipment> planTable;

    @FXML
    private TableColumn<Equipment, Integer> planId;

    @FXML
    private TableColumn<Equipment, String> planName;

    @FXML
    private TableColumn<Equipment, String> planLocation;

    @FXML
    private TableColumn<Equipment, String> planMaintenance;

    @FXML
    private TableColumn<Equipment, String> planStatus;

    @FXML
    private MenuButton menuBrigade;

    @FXML
    private ListView<?> listOfInstruments;

    @FXML
    private Button deletePlanItem;

    @FXML
    private Button createPlanBut;

    @FXML
    void initialize() {



    }

}

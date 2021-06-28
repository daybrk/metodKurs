package org.example.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;
import org.example.ConnectDB;
import org.example.QueryClass;
import org.example.entities.Equipment;

import java.util.List;

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
    private MenuItem first;

    @FXML
    private MenuItem second;

    @FXML
    private MenuItem third;

    @FXML
    private ListView<String> listOfInstruments;

    @FXML
    private Button deletePlanItem;

    @FXML
    private Button createPlanBut;

    private static ObservableList<Equipment> plan = FXCollections.observableArrayList();
    private final ObservableList<String> maintenanceTools = FXCollections.observableArrayList();

    String brigade;

    @FXML
    void initialize() {

        setItemToTable();
        updateMaintenanceList();

        deletePlanItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                plan.remove(planTable.getSelectionModel().getSelectedItem());
                planTable.getItems().remove(planTable.getSelectionModel().getSelectedItem());
                updateMaintenanceList();
            }
        });

        first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuBrigade.setText(first.getText());
                brigade = "1 Бригада";
            }
        });

        second.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuBrigade.setText(second.getText());
                brigade = "2 Бригада";

            }
        });

        third.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                menuBrigade.setText(third.getText());
                brigade = "3 Бригада";
            }
        });

        createPlanBut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                for (int i = 0; i < plan.size(); i++) {
                    QueryClass.addEquipToWork(ConnectDB.maxId, plan.get(i).getNameOfEquip(),
                            plan.get(i).getEquipLocation(), plan.get(i).getMaintenanceTools(),
                            plan.get(i).getNextValueSOT(), "Проверка", "Проверка");
                }
                QueryClass.addNewInWork(ConnectDB.maxId, brigade, "В работе");
                ConnectDB.maxId++;
            }
        });
    }

    private void setItemToTable() {

        planId.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("number"));
        planName.setCellValueFactory(new PropertyValueFactory<Equipment, String>("nameOfEquip"));
        planLocation.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equipLocation"));
        planMaintenance.setCellValueFactory(new PropertyValueFactory<Equipment, String>("maintenanceTools"));
        planStatus.setCellValueFactory(new PropertyValueFactory<Equipment, String>("nextValueSOT"));

        plan = MainFrame.eq;
        planTable.setItems(plan);
    }

    private void updateMaintenanceList() {

        maintenanceTools.clear();
        listOfInstruments.setItems(maintenanceTools);

        for (Equipment equipment : plan) {
            maintenanceTools.add(equipment.getMaintenanceTools());
        }

        listOfInstruments.setItems(maintenanceTools);
    }

}

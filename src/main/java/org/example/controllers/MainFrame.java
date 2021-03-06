package org.example.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.QueryClass;
import org.example.entities.Equipment;

public class MainFrame {


    @FXML
    private TableView<Equipment> selectedItemTable;

    @FXML
    private TableColumn<Equipment, Integer> selectedId;

    @FXML
    private TableColumn<Equipment, String> selectedName;

    @FXML
    private TableColumn<Equipment, String> selectedLocation;

    @FXML
    private TableColumn<Equipment, String> selectedMaintenance;

    @FXML
    private TableColumn<Equipment, String> selectedNextValueSOT;

    @FXML
    private TableView<Equipment> allItemTable;

    @FXML
    private TableColumn<Equipment, Integer> numberOfAll;

    @FXML
    private TableColumn<Equipment, String> nameOfAllItem;

    @FXML
    private TableColumn<Equipment, String> locationOfAll;

    @FXML
    private TableColumn<Equipment, String> maintenanceOfAll;

    @FXML
    private TableColumn<Equipment, String> nextValueSOTOfAll;

    @FXML
    private Button createPlanBut;

    @FXML
    private Button addItemBut;

    @FXML
    private Button deleteSelectedItem;

    @FXML
    private Button inWorkBut;


    public static final ObservableList<Equipment> eq = FXCollections.observableArrayList();

    private final ObservableList<Equipment> listOfEquip = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        addNewEquip();

        setItemToTable();
        setSelectedItemToTable();

        deleteSelectedItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                selectedItemTable.getItems().remove(selectedItemTable.getSelectionModel().getSelectedItem());
            }
        });

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

        inWorkBut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    App.addScene("listOfPlans.fxml", 500, 1000);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void addNewEquip() {

        List<Equipment> list;
        list = QueryClass.loadEquipFromDB();

        listOfEquip.addAll(list);

    }

    private void setItemToTable() {

        numberOfAll.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("number"));
        nameOfAllItem.setCellValueFactory(new PropertyValueFactory<Equipment, String>("nameOfEquip"));
        locationOfAll.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equipLocation"));
        maintenanceOfAll.setCellValueFactory(new PropertyValueFactory<Equipment, String>("maintenanceTools"));
        nextValueSOTOfAll.setCellValueFactory(new PropertyValueFactory<Equipment, String>("nextValueSOT"));

        allItemTable.setItems(listOfEquip);

    }

    private void setSelectedItemToTable() {

        selectedId.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("number"));
        selectedName.setCellValueFactory(new PropertyValueFactory<Equipment, String>("nameOfEquip"));
        selectedLocation.setCellValueFactory(new PropertyValueFactory<Equipment, String>("equipLocation"));
        selectedMaintenance.setCellValueFactory(new PropertyValueFactory<Equipment, String>("maintenanceTools"));
        selectedNextValueSOT.setCellValueFactory(new PropertyValueFactory<Equipment, String>("nextValueSOT"));

        addItemBut.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                eq.addAll(allItemTable.getSelectionModel().getSelectedItem());
                selectedItemTable.setItems(eq);
            }
        });

    }

}

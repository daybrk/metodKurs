package org.example.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.QueryClass;
import org.example.entities.EquipmentsInWork;
import org.example.entities.InWork;

public class ListOfPlans {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<InWork> inWorkTable;

    @FXML
    private TableColumn<InWork, Integer> inWorkId;

    @FXML
    private TableColumn<InWork, String> inWorkStatus;

    @FXML
    private TableView<EquipmentsInWork> tableDescription;

    @FXML
    private TableColumn<EquipmentsInWork, Integer> desId;

    @FXML
    private TableColumn<EquipmentsInWork, String> desName;

    @FXML
    private TableColumn<EquipmentsInWork, String> desLocation;

    @FXML
    private TableColumn<EquipmentsInWork, String> desMainten;


    @FXML
    private TableColumn<EquipmentsInWork, String> desInspector;

    @FXML
    private Button closeWorkButton;

    @FXML
    private Button openFault;

    private final ObservableList<InWork> inWorkList = FXCollections.observableArrayList();
    private final ObservableList<EquipmentsInWork> descList = FXCollections.observableArrayList();

    @FXML
    void initialize() {

        loadEquip();
        setItemToTable();

    }

    private void loadEquip() {

        List<InWork> listInWork;
        listInWork = QueryClass.loadInWork();
        inWorkList.addAll(listInWork);

        List<EquipmentsInWork> equipInWork;
        equipInWork = QueryClass.loadEquipInWork();
        descList.addAll(equipInWork);
    }

    private void setItemToTable() {

        inWorkId.setCellValueFactory(new PropertyValueFactory<InWork, Integer>("inWorkId"));
        inWorkStatus.setCellValueFactory(new PropertyValueFactory<InWork, String>("workStatus"));

        desId.setCellValueFactory(new PropertyValueFactory<EquipmentsInWork, Integer>("id"));
        desName.setCellValueFactory(new PropertyValueFactory<EquipmentsInWork, String>("nameOfEquip"));
        desLocation.setCellValueFactory(new PropertyValueFactory<EquipmentsInWork, String>("equipLocation"));
        desMainten.setCellValueFactory(new PropertyValueFactory<EquipmentsInWork, String>("maintenanceTools"));
        desInspector.setCellValueFactory(new PropertyValueFactory<EquipmentsInWork, String>("inspector"));

        tableDescription.setItems(descList);
        inWorkTable.setItems(inWorkList);
    }

}

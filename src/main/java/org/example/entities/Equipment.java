package org.example.entities;

import javafx.collections.ObservableList;

import java.util.Date;

public class Equipment {

    private int number;
    private String nameOfEquip;
    private String equipLocation;
    private String maintenanceTools;
    private String nextValueSOT;

    public Equipment(int number, String nameOfEquip, String equipLocation, String maintenanceTools, String nextValueSOT) {
        this.number = number;
        this.nameOfEquip = nameOfEquip;
        this.equipLocation = equipLocation;
        this.maintenanceTools = maintenanceTools;
        this.nextValueSOT = nextValueSOT;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNameOfEquip() {
        return nameOfEquip;
    }

    public void setNameOfEquip(String nameOfEquip) {
        this.nameOfEquip = nameOfEquip;
    }

    public String getEquipLocation() {
        return equipLocation;
    }

    public void setEquipLocation(String equipLocation) {
        this.equipLocation = equipLocation;
    }

    public String getMaintenanceTools() {
        return maintenanceTools;
    }

    public void setMaintenanceTools(String maintenanceTools) {
        this.maintenanceTools = maintenanceTools;
    }

    public String getNextValueSOT() {
        return nextValueSOT;
    }

    public void setNextValueSOT(String nextValueSOT) {
        this.nextValueSOT = nextValueSOT;
    }
}

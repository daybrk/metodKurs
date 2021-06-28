package org.example.entities;

public class EquipmentsInWork {

    private int id;
    private String nameOfEquip;
    private String equipLocation;
    private String maintenanceTools;
    private String nextValueSOT;
    private String faultCause;
    private String inspector;

    public EquipmentsInWork(int id, String nameOfEquip, String equipLocation, String maintenanceTools,
                            String nextValueSOT, String faultCause, String inspector) {
        this.id = id;
        this.nameOfEquip = nameOfEquip;
        this.equipLocation = equipLocation;
        this.maintenanceTools = maintenanceTools;
        this.nextValueSOT = nextValueSOT;
        this.faultCause = faultCause;
        this.inspector = inspector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFaultCause() {
        return faultCause;
    }

    public void setFaultCause(String faultCause) {
        this.faultCause = faultCause;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }
}

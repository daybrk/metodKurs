package org.example.entities;

public class InWork {

    private int inWorkId;
    private String brigade;
    private String workStatus;

    public InWork(int inWorkId, String brigade, String workStatus) {
        this.inWorkId = inWorkId;
        this.brigade = brigade;
        this.workStatus = workStatus;
    }

    public int getInWorkId() {
        return inWorkId;
    }

    public void setInWorkId(int inWorkId) {
        this.inWorkId = inWorkId;
    }

    public String getBrigade() {
        return brigade;
    }

    public void setBrigade(String brigade) {
        this.brigade = brigade;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
}

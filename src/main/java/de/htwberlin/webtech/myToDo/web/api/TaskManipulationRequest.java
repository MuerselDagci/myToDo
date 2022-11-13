package de.htwberlin.webtech.myToDo.web.api;

public class TaskManipulationRequest {

    private String titel;
    private String status;
    private String duedate;

    public TaskManipulationRequest(String titel, String status, String duedate) {
        this.titel = titel;
        this.status = status;
        this.duedate = duedate;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}

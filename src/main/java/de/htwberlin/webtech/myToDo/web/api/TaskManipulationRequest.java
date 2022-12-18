package de.htwberlin.webtech.myToDo.web.api;

public class TaskManipulationRequest {

    private String titel;
    private String status;
    private String wiederholung;
    private String duedate;

    public TaskManipulationRequest(String titel, String status,String wiederholung, String duedate) {
        this.titel = titel;
        this.status = status;
        this.wiederholung = wiederholung;
        this.duedate = duedate;
    }
    public TaskManipulationRequest(){}

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

    public String getWiederholung() {
        return wiederholung;
    }

    public void setWiederholung(String wiederholung) {
        this.wiederholung = wiederholung;
    }
}

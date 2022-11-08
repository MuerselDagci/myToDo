package de.htwberlin.webtech.myToDo.web.api;

public class Task {

    private String status;
    private String titel;
    private String duedate;

    public Task(String status, String titel, String duedate) {
        this.status = status;
        this.titel = titel;
        this.duedate = duedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }
}

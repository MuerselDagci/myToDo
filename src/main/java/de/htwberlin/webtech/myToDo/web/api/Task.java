package de.htwberlin.webtech.myToDo.web.api;

import javax.persistence.Id;

public class Task {

    private long id;
    private String status;
    private String titel;
    private String duedate;

    public Task(long id, String status, String titel, String duedate) {
        this.id = id;
        this.status = status;
        this.titel = titel;
        this.duedate = duedate;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {this.id = id;}

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

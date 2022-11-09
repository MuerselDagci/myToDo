package de.htwberlin.webtech.myToDo.presistance;

import javax.persistence.*;

@Entity(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "titel",nullable = false)
    private String titel;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "duedate")
    private String duedate;

    @Column(name = "test")
    private String testColumn;

    public TaskEntity(String titel, String status, String duedate) {
        this.titel = titel;
        this.status = status;
        this.duedate = duedate;
    }

    protected TaskEntity() {}

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

    public String getTestColumn() {
        return testColumn;
    }

    public void setTestColumn(String testColumn) {
        this.testColumn = testColumn;
    }
}

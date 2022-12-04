package de.htwberlin.webtech.myToDo.presistance;

import javax.persistence.*;


@Entity(name = "taskss")

public class TaskEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (name = "titel", nullable = false)
    private String titel;

    @Column(name = "status",nullable = false)
    private String status;

    @Column (name = "duedate",nullable = false)
    private String duedate;

    @Column(name = "Wiederholung" )
    @Enumerated(value = EnumType.STRING)
    private Wiederholung wiederholung;


    public TaskEntity(String titel,String status, String duedate, Wiederholung wiederholung){
        this.titel=titel;
        this.status= status;
        this.duedate=duedate;
        this.wiederholung= wiederholung;
    }

    public TaskEntity() {

    }

    public Long getId() {
        return id;
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

    public Wiederholung getWiederholung() {
        return wiederholung;
    }

    public void setWiederholung(Wiederholung wiederholung) {
        this.wiederholung = wiederholung;
    }
}



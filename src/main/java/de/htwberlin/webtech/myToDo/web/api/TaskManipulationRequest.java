package de.htwberlin.webtech.myToDo.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TaskManipulationRequest {
    @Size(min = 3,message = "Bitte mehr als 3 Buchstaben")
    private String titel;

    private String status;

    @Pattern(
          regexp = "TAEGLICH|WOCHENTLICH|MONATLICH|JAEHRLICH",
          message = "Bitte entweder das oder das"
    )
    private String wiederholung;

    private String mitarbeiter;

    private String duedate;

    @NotBlank(message = "Bitte nicht leer")
    private String beschreibung;

    public TaskManipulationRequest(String titel, String status,String wiederholung, String duedate,String beschreibung,String mitarbeiter) {
        this.titel = titel;
        this.status = status;
        this.wiederholung = wiederholung;
        this.duedate = duedate;
        this.beschreibung=beschreibung;
        this.mitarbeiter=mitarbeiter;
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

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(String mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }
}

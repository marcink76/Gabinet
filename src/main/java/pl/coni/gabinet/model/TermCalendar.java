package pl.coni.gabinet.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class TermCalendar {
    @Id
    @GeneratedValue
    private long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private long userId;
    private LocalDate day;
    private LocalDateTime startDateTime;
    private int treatmentSet;

    public TermCalendar(long userId, LocalDate day, LocalDateTime startDateTime, int treatmentSet) {
        this.userId = userId;
        this.day = day;
        this.startDateTime = startDateTime;
        this.treatmentSet = treatmentSet;
    }

    public TermCalendar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public int getTreatmentSet() {
        return treatmentSet;
    }

    public void setTreatmentSet(int treatmentSet) {
        this.treatmentSet = treatmentSet;
    }
}

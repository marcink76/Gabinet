package pl.coni.gabinet.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Termin {
    @Id
    @GeneratedValue()
    private long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private LocalTime summaryDurationTime;

    @OneToOne
    private Employee employee;

    @ManyToOne
    @JoinColumn
    private Customer customer;

    @ManyToMany
    private List<Treatment> treatmentList;

    public Termin(LocalDate date, LocalTime startTime, LocalTime endTime, LocalTime summaryDurationTime, Employee employee, Customer user, List<Treatment> treatmentList) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.summaryDurationTime = summaryDurationTime;
        this.employee = employee;
        this.customer = customer;
        this.treatmentList = treatmentList;
    }

    public Termin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getSummaryDurationTime() {
        return summaryDurationTime;
    }

    public void setSummaryDurationTime(LocalTime summaryDurationTime) {
        this.summaryDurationTime = summaryDurationTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", summaryDurationTime=" + summaryDurationTime +
                ", employee=" + employee +
                ", customer=" + customer +
                ", treatmentList=" + treatmentList +
                '}';
    }
}

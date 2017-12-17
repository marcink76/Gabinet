package pl.coni.gabinet.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date startDate;
    private Date endDate;
    private Time summaryDurationTime;

    @OneToOne
    private Employee employee;

    @OneToOne
    private Customer user;

    @OneToMany
    private List<Treatment> treatmentList;

    public Termin(Date startDate, Date endDate, Time summaryDurationTime) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.summaryDurationTime = summaryDurationTime;
    }

    public Termin() {
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getSummaryDurationTime() {
        return summaryDurationTime;
    }

    public void setSummaryDurationTime(Time summaryDurationTime) {
        this.summaryDurationTime = summaryDurationTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

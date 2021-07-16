package com.dotin.RequestManager.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_timeOffRequest")
public class TimeOffRequest extends BaseEntity {
    @Column(name = "c_startDate")
    private String startDate;
    @Column(name = "c_endDate")
    private String endDate;
    @Column(name = "startTime")
    private String startTime;
    @Column(name = "endTime")
    private String endTime;
    @Column(name = "c_timeOffDayAmount")
    private Integer timeOffDayAmount = 0;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private CategoryElement requestType;
    @ManyToOne
    @JoinColumn(name = "c_timeOffStatus")
    private CategoryElement timeOffStatus;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CategoryElement getRequestType() {
        return requestType;
    }

    public void setRequestType(CategoryElement requestType) {
        this.requestType = requestType;
    }

    public CategoryElement getTimeOffStatus() {
        return timeOffStatus;
    }

    public void setTimeOffStatus(CategoryElement timeOffStatus) {
        this.timeOffStatus = timeOffStatus;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getTimeOffDayAmount() {
        return timeOffDayAmount;
    }

    public void setTimeOffDayAmount(Integer timeOffDayAmount) {
        this.timeOffDayAmount = timeOffDayAmount;
    }
}

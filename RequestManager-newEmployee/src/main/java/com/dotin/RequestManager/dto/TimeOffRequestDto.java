package com.dotin.RequestManager.dto;


public class TimeOffRequestDto extends BaseEntity {
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private Integer timeOffDayAmount = 0;
    private Long employeeId;
    private Long timeOffStatusId;
    private Long requestType;
    private double timeOffBalance;


    public double getTimeOffBalance() {
        return timeOffBalance;
    }

    public void setTimeOffBalance(double timeOffBalance) {
        this.timeOffBalance = timeOffBalance;
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

    public Integer getTimeOffDayAmount() {
        return timeOffDayAmount;
    }

    public void setTimeOffDayAmount(Integer timeOffDayAmount) {
        this.timeOffDayAmount = timeOffDayAmount;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getTimeOffStatusId() {
        return timeOffStatusId;
    }

    public void setTimeOffStatusId(Long timeOffStatusId) {
        this.timeOffStatusId = timeOffStatusId;
    }

    public Long getRequestType() {
        return requestType;
    }

    public void setRequestType(Long requestType) {
        this.requestType = requestType;
    }


    @Override
    public String toString() {
        return "TimeOffRequestDto{" +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", timeOffDayAmount=" + timeOffDayAmount +
                ", employeeId=" + employeeId +
                ", timeOffStatusId=" + timeOffStatusId +
                '}';
    }
}

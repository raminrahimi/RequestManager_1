package com.dotin.RequestManager.mapper;

import com.dotin.RequestManager.dao.CategoryElementDao;
import com.dotin.RequestManager.dao.EmployeeDao;
import com.dotin.RequestManager.dto.TimeOffRequestDto;
import com.dotin.RequestManager.entity.CategoryElement;
import com.dotin.RequestManager.entity.Employee;
import com.dotin.RequestManager.entity.TimeOffRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TimeOffRequestMapper {
    private final CategoryElementDao categoryElementDao;
    private final EmployeeDao employeeDao;

    public TimeOffRequestMapper() {
        this.categoryElementDao = new CategoryElementDao();
        this.employeeDao = new EmployeeDao();
    }

    public TimeOffRequest toEntity(TimeOffRequestDto timeOffRequestDto) {
        TimeOffRequest timeOffRequest = new TimeOffRequest();
        timeOffRequest.setId(timeOffRequestDto.getId());
        if (timeOffRequestDto.getTimeOffStatusId() != null) {
            Session session = categoryElementDao.openCurrentSession();
            try {
                Transaction transaction = session.beginTransaction();
                CategoryElement status = categoryElementDao.getEntity(timeOffRequestDto.getTimeOffStatusId());
                timeOffRequest.setTimeOffStatus(status);
                transaction.commit();
            } finally {
                session.close();
            }
        }
        timeOffRequest.setTimeOffDayAmount(timeOffRequestDto.getTimeOffDayAmount());
        if (timeOffRequestDto.getEmployeeId() != null) {
            Session session = employeeDao.openCurrentSession();
            try {
                Transaction transaction = session.beginTransaction();
                Employee employee = employeeDao.getEntity(timeOffRequestDto.getEmployeeId());
                timeOffRequest.setEmployee(employee);
                transaction.commit();
            } finally {
                session.close();
            }
        }
        timeOffRequest.setActive(timeOffRequestDto.getActive());
        timeOffRequest.setEndDate(timeOffRequestDto.getEndDate());
        timeOffRequest.setStartDate(timeOffRequestDto.getStartDate());
        timeOffRequest.setStartTime(timeOffRequestDto.getStartTime());
        timeOffRequest.setEndTime(timeOffRequestDto.getEndTime());
        if (timeOffRequestDto.getRequestType() != null) {
            Session session = categoryElementDao.openCurrentSession();
            try {
                Transaction transaction = session.beginTransaction();
                CategoryElement dateTime = categoryElementDao.getEntity(timeOffRequestDto.getRequestType());
                timeOffRequest.setRequestType(dateTime);
                transaction.commit();
            } finally {
                session.close();
            }
        }
        timeOffRequest.setDisable(timeOffRequestDto.getDisable());
        timeOffRequest.setVersion(timeOffRequestDto.getVersion());
        return timeOffRequest;
    }

    public TimeOffRequestDto toDto(TimeOffRequest timeOffRequest) {
        TimeOffRequestDto timeOffRequestDto = new TimeOffRequestDto();
        timeOffRequestDto.setId(timeOffRequest.getId());
        timeOffRequestDto.setActive(timeOffRequest.getActive());
        timeOffRequestDto.setDisable(timeOffRequest.getDisable());
        timeOffRequestDto.setEmployeeId(timeOffRequest.getEmployee() != null ? timeOffRequest.getEmployee().getId() : null);
        timeOffRequestDto.setEndTime(timeOffRequest.getEndTime());
        timeOffRequestDto.setStartTime(timeOffRequest.getStartTime());
        timeOffRequestDto.setStartDate(timeOffRequest.getStartDate());
        timeOffRequestDto.setEndDate(timeOffRequest.getEndDate());
        timeOffRequestDto.setRequestType(timeOffRequest.getRequestType() != null ? timeOffRequest.getRequestType().getId() : null);
        timeOffRequestDto.setTimeOffDayAmount(timeOffRequest.getTimeOffDayAmount());
        timeOffRequestDto.setTimeOffStatusId(timeOffRequest.getTimeOffStatus() != null ? timeOffRequest.getTimeOffStatus().getId() : null);
        timeOffRequestDto.setVersion(timeOffRequest.getVersion());
        return timeOffRequestDto;
    }
}

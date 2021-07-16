package com.dotin.RequestManager.mapper;

import com.dotin.RequestManager.dao.EmployeeDao;
import com.dotin.RequestManager.dto.EmailDto;
import com.dotin.RequestManager.entity.Email;
import com.dotin.RequestManager.entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class EmailMapper {
    private final EmployeeDao employeeDao;

    public EmailMapper() {
        this.employeeDao = new EmployeeDao();
    }

    public Email toEntity(EmailDto emailDto) {
        Email email = new Email();
        email.setId(emailDto.getId());
        email.setSubject(emailDto.getSubject());
        email.setDescription(emailDto.getDescription());
        email.setActive(emailDto.getActive());
        email.setDisable(emailDto.getDisable());
        if (emailDto.getSenderId() != null) {
            Session session = employeeDao.openCurrentSession();
            try {
                Transaction transaction = session.beginTransaction();
                Employee sender = employeeDao.getEntity(emailDto.getSenderId());
                email.setSender(sender);
                transaction.commit();
            } finally {
                session.close();
            }
        }
        if (emailDto.getReceiverId() != null) {
            Set<Employee> receiverList = new HashSet<>();
            Session session = employeeDao.openCurrentSession();
            Transaction transaction = session.beginTransaction();
            try {
                for (Long id : emailDto.getReceiverId()) {
                    Employee receiver = employeeDao.getEntity(id);
                    receiverList.add(receiver);
                }
                email.setRecivers(receiverList);
                transaction.commit();
            } finally {
                session.close();
            }
        }
        return email;
    }

    public EmailDto toDto(Email email) {
        EmailDto emailDto = new EmailDto();
        emailDto.setId(email.getId());
        emailDto.setActive(email.getActive());
        emailDto.setDescription(email.getDescription());
        emailDto.setDisable(email.getDisable());
        emailDto.setSubject(email.getSubject());
        emailDto.setVersion(email.getVersion());
        emailDto.setSenderId(email.getSender() != null ? email.getSender().getId() : null);
        Set<Long> receiverList = new HashSet<>();
        for (Employee employee : email.getRecivers()) {
            receiverList.add(employee.getId());
        }
        emailDto.setReceiverId(receiverList);
        return emailDto;
    }
}

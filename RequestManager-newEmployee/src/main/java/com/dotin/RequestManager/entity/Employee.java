package com.dotin.RequestManager.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_employee")
public class Employee extends BaseEntity {
    @Column(name = "c_timeOffBalance")
    private double timeOffBalance;
    @Column(name = "c_firstName")
    private String firstName;
    @Column(name = "c_lastName")
    private String lastName;
    @Column(name = "c_nationalCode")
    private String nationalCode;
    @Column(name = "c_phoneNumber")
    private String phoneNumber;
    @Column(name = "c_address")
    private String address;
    @Column(name = "c_emailAdress")
    private String emailAdress;
    @ManyToOne
    @JoinColumn(name = "c_role")
    private CategoryElement role;
    @ManyToOne()
    @JoinColumn(name = "c_userManager")
    private Employee Manager;

    public CategoryElement getRole() {
        return role;
    }

    public void setRole(CategoryElement role) {
        this.role = role;
    }

    public Employee getManager() {
        return Manager;
    }

    public void setManager(Employee manager) {
        Manager = manager;
    }


    public double getTimeOffBalance() {
        return timeOffBalance;
    }

    public void setTimeOffBalance(double timeOffBalance) {
        this.timeOffBalance = timeOffBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
}

package com.dotin.RequestManager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_email")
public class Email extends BaseEntity {
    @Column(name = "c_subject")
    private String subject;
    @Column(name = "c_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "c_sender")
    private Employee sender;
    @Column(name = "c_attachFilePath")
    @ManyToMany
    @JoinTable(
            name = "t_emailReceiver",
            joinColumns = @JoinColumn(name = "c_email_id"),
            inverseJoinColumns = @JoinColumn(name = "c_employee_id"))
    private Set<Employee> recivers;

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public Set<Employee> getRecivers() {
        return recivers;
    }

    public void setRecivers(Set<Employee> recivers) {
        this.recivers = recivers;
    }



    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

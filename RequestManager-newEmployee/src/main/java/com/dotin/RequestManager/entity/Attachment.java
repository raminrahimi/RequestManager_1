package com.dotin.RequestManager.entity;
import javax.persistence.*;


@Entity
@Table(name = "t_attachment")
public class Attachment extends BaseEntity {

    @Column(name = "c_file_name")
    private String fileName;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Email.class)
    @JoinColumn(name = "c_email")
    private Email email;



    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }



    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}


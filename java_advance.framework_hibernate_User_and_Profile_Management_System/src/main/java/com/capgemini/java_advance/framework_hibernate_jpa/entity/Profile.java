package com.capgemini.java_advance.framework_hibernate_jpa.entity;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String phone;
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dob;

    public Profile() {}

    public Profile(String phone, String gender, Date dob) {
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

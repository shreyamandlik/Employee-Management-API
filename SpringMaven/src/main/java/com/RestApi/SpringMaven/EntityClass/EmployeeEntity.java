package com.RestApi.SpringMaven.EntityClass;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@JsonPropertyOrder({"id", "First_name", "Last_name", "Email", "Job_title", "Contact_number"})

public class EmployeeEntity {
    @Id
    private long id;
    
    private String First_name;
   
    private String Last_name;
    
    private String Job_title;
 
    private String Email;
    
    private int Contact_number;

    public EmployeeEntity(long id, String first_name, String last_name, String job_title, String email,
            int contact_number) {
        super();
        this.id = id;
        First_name = first_name;
        Last_name = last_name;
        Job_title = job_title;
        Email = email;
        Contact_number = contact_number;
    }

    public EmployeeEntity() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
       First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getJob_title() {
        return Job_title;
    }

    public void setJob_title(String job_title) {
       Job_title = job_title;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
       Email = email;
    }

    public int getContact_number() {
        return Contact_number;
    }

    public void setContact_number(int contact_number) {
        Contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", First_name=" + First_name + ", Last_name=" + Last_name + ", Job_title="
                + Job_title + ", Email=" + Email + ", Contact_number=" + Contact_number + "]";
    }

    public static Object status(HttpStatus notFound) {
        return null;
    }

    public static EmployeeEntity ok(EmployeeEntity foundEmployee) {
        return null;
    }

}

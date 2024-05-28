package com.assignment.schoolManagementApp.models;

import jakarta.validation.constraints.*;

import java.util.Date;

public class TeachersDto {


    private int id;
    @NotBlank(message = "The name is required")
    private String name;
    @NotNull(message = "The gender is required")
    private String gender;
    @Min(20)
    private Integer age;
    @NotNull(message = "The email is required")
    private String email;

    @NotNull(message = "The phone number is required")
    private String phone_number;


    private Date hiring_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getHiring_date() {
        return hiring_date;
    }

    public void setHiring_date(Date hiring_date) {
        this.hiring_date = hiring_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

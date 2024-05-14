package com.example.brtapp;

public class User {
    private String email;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private String idCardNumber;
    private String phoneNumber;
    public User(){}
    public User(String newEmail, String newPassword, String newFullName,String newDateOfBirth, String newIdCardNumber, String newPhoneNumber){
        setEmail(newEmail);
        setPassword(newPassword);
        setFullName(newFullName);
        setDateOfBirth(newDateOfBirth);
        setIdCardNumber(newIdCardNumber);
        setPhoneNumber(newPhoneNumber);
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package com.twu.biblioteca.model;

/**
 * Created by michalhuzevka on 5/03/15.
 */
public class UserAccount {
    private String ID;
    //eventually change this so we dont store plaintext password
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private UserType userType;

    public UserAccount(String ID, String password, String firstName, String lastName, String email, String phoneNumber, UserType userType) {
        this.ID = ID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.email = email;
        this.phoneNumber = "44445555";
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

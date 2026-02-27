package com.contactsapp.model;

import java.util.*;

public class User {
    private String name;
    private String email;
    private String hashedPassword;
    private String phoneNumber;
    private UserType type;
    
    /**
     * @param name
     * @param email
     * @param hashedPassword
     * @param phoneNumber
     * @param type
     */
    public User(String name, String email, String hashedPassword, String phoneNumber, UserType type) {
        this.name = name;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    // Getters for Encapsulation
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getHashPwd() { return hashedPassword; } 
    public String getPhoneNumber() { return phoneNumber; }
    public UserType getType() { return type; }
    
    /**
     * @param name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.matches("\\d{10}")) {
            this.phoneNumber = phoneNumber;
        }
    }

    // Security best practice: Hashing is handled internally
    public void updatePassword(String newHashedPassword) {
        this.hashedPassword = newHashedPassword;
    }
    
    private List<Contact> myContacts = new ArrayList<>();

    public List<Contact> getMyContacts() { return myContacts; }

    public void addContact(Contact contact) {
        this.myContacts.add(contact);
    }
}
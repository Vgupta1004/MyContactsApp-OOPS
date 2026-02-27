package com.contactsapp.service;
import com.contactsapp.model.User;

public interface Authenticator {
    User authenticate(String email, String password); // Abstraction
}
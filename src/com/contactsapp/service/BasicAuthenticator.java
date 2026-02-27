package com.contactsapp.service;
import com.contactsapp.controller.UserController;
import com.contactsapp.model.User;

public class BasicAuthenticator implements Authenticator {
    @Override
    public User authenticate(String email, String password) {
        return UserController.getInstance().login(email, password); // Polymorphism
    }
}
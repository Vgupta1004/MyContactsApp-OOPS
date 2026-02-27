package com.contactsapp.controller;
import com.contactsapp.model.*;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class UserController {
    private static UserController instance;
    private Map<String, User> userDatabase = new HashMap<>(); // Encapsulation

    private UserController() {}

    public static UserController getInstance() {
        if (instance == null) instance = new UserController();
        return instance; // Singleton
    }

    public Map<String, User> getUserDatabase() { return userDatabase; }

    public String register(String name, String email, String password, String phone, UserType type) {
        if (userDatabase.containsKey(email.toLowerCase())) return "Error: Email exists.";
        String hashed = hashPassword(password);
        userDatabase.put(email.toLowerCase(), new User(name, email.toLowerCase(), hashed, phone, type));
        return "Success: Account created for " + name;
    }

    public User login(String email, String password) {
        User user = userDatabase.get(email.toLowerCase());
        if (user != null && user.getHashPwd().equals(hashPassword(password))) return user;
        return null;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString(); // Password hashing
        } catch (Exception e) { return password; }
    }
}
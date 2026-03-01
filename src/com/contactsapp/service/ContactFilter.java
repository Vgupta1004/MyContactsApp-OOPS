package com.contactsapp.service;

import com.contactsapp.model.Contact;
import java.util.List;

public interface ContactFilter {
    // Simple filter interface
    void applyFilter(List<Contact> contacts);
}
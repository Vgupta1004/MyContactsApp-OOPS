package com.contactsapp.service;

import com.contactsapp.model.Contact;
import java.util.List;

public interface SearchCriteria {
    // Interface for search functionality
    List<Contact> search(List<Contact> contacts, String query);
}
package com.fiipractic.agenda.rest.services;

import java.util.List;

import com.fiipractic.agenda.rest.models.Contact;

public interface ContactService {

    List<Contact> getContactsForUsername(String username);

    Contact getContactForUsername(String username, Long contactId);

    Contact createContact(String username, Contact contact);

    Contact updateContact(String username, Long contactId, Contact contact);

    void deleteContact(String username, Long contactId);
}

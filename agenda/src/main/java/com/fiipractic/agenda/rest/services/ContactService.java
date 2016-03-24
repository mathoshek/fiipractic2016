package com.fiipractic.agenda.rest.services;

import java.util.List;

import com.fiipractic.agenda.rest.models.Contact;

public interface ContactService {

    List<Contact> getContactsForUsername(String username);

    Contact getContactForUsername(String username, Long contactId);

    Contact createContactForUsername(String username, Contact contact);

    Contact updateContactForUsername(String username, Long contactId, Contact contact);

    void deleteContactForUsername(String username, Long contactId);
}

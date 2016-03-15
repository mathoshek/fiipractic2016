package com.fiipractic.agenda.rest.services;

import com.fiipractic.agenda.rest.models.Contact;

import java.util.List;

/**
 * File created by a.chmilevski on 3/15/2016 - 1:14 PM.
 * RadiON
 */
public interface ContactService {
    List<Contact> getContactsForUsername(String username);

    Contact getContactForUsername(Long contactId, String username);

    Contact createContactForUsername(Contact contact, String username);

    Contact updateContactForUsername(Long contactId, Contact contact, String username);

    void deleteContactForUsername(Long contactId, String username);
}

package com.fiipractic.agenda.rest.storage;

import com.fiipractic.agenda.rest.models.Contact;

import java.util.List;

/**
 * File created by a.chmilevski on 3/15/2016 - 1:15 PM. RadiON
 */
public interface ContactDao {
    Contact getById(Long contactId);

    List<Contact> getForUsername(String username);

    void add(Contact contact);

    Contact update(Contact contact);

    void delete(Contact contact);
}

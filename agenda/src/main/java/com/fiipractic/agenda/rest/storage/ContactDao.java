package com.fiipractic.agenda.rest.storage;

import java.util.List;

import com.fiipractic.agenda.rest.models.Contact;

public interface ContactDao {

    List<Contact> getForUsername(String username);

    Contact getById(String username, Long contactId);

    void add(Contact contact);

    void update(Contact contact);

    void delete(Contact contact);

}

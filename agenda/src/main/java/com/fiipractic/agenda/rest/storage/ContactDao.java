package com.fiipractic.agenda.rest.storage;

import java.util.List;
import java.util.Map;

import com.fiipractic.agenda.rest.models.Contact;

public interface ContactDao {

    List<Contact> getForUsername(String username);
    
    List<Contact> getForUsernameFiltered(String username, Map<String, String> q);

    Contact getById(String username, Long contactId);

    void add(Contact contact);

    Contact update(Contact contact);

    void delete(Contact contact);

}

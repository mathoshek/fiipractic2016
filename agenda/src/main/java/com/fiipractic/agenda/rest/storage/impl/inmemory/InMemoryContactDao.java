package com.fiipractic.agenda.rest.storage.impl.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.storage.ContactDao;

//@Repository
public class InMemoryContactDao implements ContactDao {

    private static Map<String, Map<Long, Contact>> contacts = new HashMap<>();

    private static Map<String, Long> contactMaxIdsByUsername = new HashMap<>();

    @Override
    public List<Contact> getForUsername(String username) {
        if (contacts.containsKey(username))
            return new ArrayList<>(contacts.get(username).values());
        return new ArrayList<>();
    }

    @Override
    public Contact getById(String username, Long contactId) {
        Map<Long, Contact> currentUserContacts = contacts.get(username);
        if (currentUserContacts == null)
            return null;
        return currentUserContacts.get(contactId);
    }

    @Override
    public void add(Contact contact) {
        User user = contact.getUser();

        long currentContactId = getCurrentContactId(user.getUsername());
        contact.setId(++currentContactId);
        contactMaxIdsByUsername.put(user.getUsername(), currentContactId);

        if (contacts.containsKey(user.getUsername())) {
            contacts.get(user.getUsername()).put(contact.getId(), contact);
        } else {
            Map<Long, Contact> newContacts = new HashMap<>();
            newContacts.put(contact.getId(), contact);
            contacts.put(user.getUsername(), newContacts);
        }

    }

    private long getCurrentContactId(String username) {
        if (contactMaxIdsByUsername.containsKey(username)) {
            return contactMaxIdsByUsername.get(username);
        }
        return 0;
    }

    @Override
    public Contact update(Contact contact) {
        User user = contact.getUser();
        Map<Long, Contact> currentUserContacts = contacts.get(user.getUsername());
        if (currentUserContacts != null && currentUserContacts.containsKey(contact.getId())) {

            currentUserContacts.put(contact.getId(), contact);
        }
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        contacts.get(contact.getUser().getUsername()).remove(contact.getId());
    }

}

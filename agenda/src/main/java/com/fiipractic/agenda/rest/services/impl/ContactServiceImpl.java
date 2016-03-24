package com.fiipractic.agenda.rest.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.services.ContactService;
import com.fiipractic.agenda.rest.storage.ContactDao;
import com.fiipractic.agenda.rest.storage.UserDao;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Contact> getContactsForUsername(String username) {
        return contactDao.getForUsername(username);
    }

    @Override
    public Contact getContactForUsername(String username, Long contactId) {
        return contactDao.getById(username, contactId);
    }

    @Override
    @Transactional
    public Contact createContactForUsername(String username, Contact contact) {
        User user = userDao.getByUsername(username);
        contact.setUser(user);
        contactDao.add(contact);
        return contact;
    }

    @Override
    @Transactional
    public Contact updateContactForUsername(String username, Long contactId, Contact contact) {
        User user = userDao.getByUsername(username);
        Contact existingContact = contactDao.getById(username, contactId);
        if (existingContact == null) {
            throw new RuntimeException("Contact does not exist");
        }
        contact.setId(existingContact.getId());
        contact.setUser(user);
        contactDao.update(contact);
        return contact;
    }

    @Override
    @Transactional
    public void deleteContactForUsername(String username, Long contactId) {
        Contact contact = contactDao.getById(username, contactId);
        contactDao.delete(contact);
    }
}
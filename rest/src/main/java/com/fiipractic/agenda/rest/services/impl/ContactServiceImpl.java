package com.fiipractic.agenda.rest.services.impl;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.services.ContactService;
import com.fiipractic.agenda.rest.storage.ContactDao;
import com.fiipractic.agenda.rest.storage.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * File created by a.chmilevski on 3/15/2016 - 1:14 PM.
 * RadiON
 */
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
    public Contact getContactForUsername(Long contactId, String username) {
        return contactDao.getById(contactId);
    }

    @Override
    @Transactional
    public Contact createContactForUsername(Contact contact, String username) {
        User user = userDao.getByUsername(username);
        contact.setUser(user);
        contactDao.add(contact);
        return contact;
    }

    @Override
    @Transactional
    public Contact updateContactForUsername(Long contactId, Contact contact, String username) {
        User user = userDao.getByUsername(username);

        return null;
    }

    @Override
    @Transactional
    public void deleteContactForUsername(Long contactId, String username) {
        User user = userDao.getByUsername(username);


    }
}

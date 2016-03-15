package com.fiipractic.agenda.rest.storage.impl;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.storage.ContactDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * File created by a.chmilevski on 3/15/2016 - 1:15 PM.
 * RadiON
 */
@Repository
public class JpaContactDao implements ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Contact getById(Long contactId) {
        return entityManager.find(Contact.class, contactId);
    }

    @Override
    public List<Contact> getForUsername(String username) {
        TypedQuery<Contact> q = entityManager.createQuery("select c from Contact c where c.user.username=:username", Contact.class);
        q.setParameter("username", username);

        return q.getResultList();
    }

    @Override
    public void add(Contact contact) {
        entityManager.persist(contact);
    }
}

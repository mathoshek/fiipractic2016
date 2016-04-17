package com.fiipractic.agenda.rest.storage.impl.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fiipractic.agenda.rest.models.Contact;
import com.fiipractic.agenda.rest.storage.ContactDao;

@Repository
public class JpaContactDao implements ContactDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contact> getForUsername(String username) {
        TypedQuery<Contact> q = entityManager.createQuery(
                "select c from Contact c where c.user.username=:username",
                Contact.class);
        q.setParameter("username", username);

        return q.getResultList();
    }

    @Override
    public List<Contact> getForUsernameFiltered(String username, Map<String, String> q) {
        String hqlQuery = "select c from Contact c where c.user.username=:username";
        
        if(q.get("name") != null){
            hqlQuery += " and c.name like :name";
        }
        
        if(q.get("phoneNumber") != null){
            hqlQuery += " and c.phoneNumber like :phoneNumber";
        }
        
        TypedQuery<Contact> query = entityManager.createQuery(hqlQuery, Contact.class);
        query.setParameter("username", username);
        if(q.get("name") != null){
            query.setParameter("name", "%" + q.get("name") + "%");
        }
        
        if(q.get("phoneNumber") != null){
            query.setParameter("phoneNumber", "%" + q.get("phoneNumber") + "%");
        }
        
        return query.getResultList();
    }

    @Override
    public Contact getById(String username, Long contactId) {
        return entityManager.find(Contact.class, contactId);
    }

    @Override
    public void add(Contact contact) {
        entityManager.persist(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return entityManager.merge(contact);
    }

    @Override
    public void delete(Contact contact) {
        entityManager.remove(contact);
    }

}

package com.fiipractic.agenda.rest.storage.impl.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.fiipractic.agenda.rest.models.User;
import com.fiipractic.agenda.rest.storage.UserDao;

@Repository
public class JpaUserDao implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);

    }

    @Override
    public User getByUsername(String username) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.username=:username", User.class);
        q.setParameter("username", username);

        return q.getSingleResult();
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> q = entityManager.createQuery("select u from User u", User.class);

        return q.getResultList();
    }

}

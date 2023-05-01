package com.app.dao;

import com.app.model.Users;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsersDaoImp implements UsersDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Users user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Users user) {
        entityManager.createQuery("DELETE FROM Users u WHERE u.id = :id ").setParameter("id", user.getId()).executeUpdate();
    }

    @Override
    public List<Users> read() {
        //TypedQuery <Users> query = (TypedQuery<Users>) entityManager.createQuery("from Users ");
        return entityManager.createQuery("from Users ").getResultList();
    }

    @Override
    public void update(Users user) {
        entityManager.merge(user);
    }
    @Override
    public Users showUser(int id) {
        return read().stream().filter(users -> users.getId() == id).findAny().orElse(null);
    }
}

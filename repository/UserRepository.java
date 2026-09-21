package com.example.demo.repository;

import com.example.demo.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Users users){
        entityManager.persist(users);
    }
    public List<Users> getAll(){
        String jpql = "Select t From Users t";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        return query.getResultList();
    }
    public Users findById(UUID id){
        return entityManager.find(Users.class,id);
    }
    public void remove(Users users){
        entityManager.remove(users);
    }
}

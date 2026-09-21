package com.example.demo.repository;

import com.example.demo.model.Transactions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TransactionRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Transactions transactions){
        entityManager.persist(transactions);
    }
    public List<Transactions> getAllTransaction(){
        String jpql = "Select t From Transactions t";
        TypedQuery <Transactions> query = entityManager.createQuery(jpql,Transactions.class);
        return query.getResultList();
    }
    public Transactions findById(UUID id){
        return entityManager.find(Transactions.class,id);
    }
    public void remove(Transactions transactions){
        entityManager.remove(transactions);
    }
}

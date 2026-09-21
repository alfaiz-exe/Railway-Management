package com.example.demo.repository;

import com.example.demo.model.Wallet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class WalletRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Wallet wallet){
        entityManager.persist(wallet);
    }
    public List<Wallet> getAll(){
        String jpql = "Select t From Wallet t";
        TypedQuery<Wallet> query = entityManager.createQuery(jpql,Wallet.class);
        return query.getResultList();
    }
    public Wallet findById(UUID id){
        return entityManager.find(Wallet.class,id);
    }
    public void remove(Wallet wallet){
        entityManager.remove(wallet);
    }
}

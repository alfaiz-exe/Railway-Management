package com.example.demo.repository;

import com.example.demo.model.CoachPrice;
import com.example.demo.model.Ticket;
import com.example.demo.model.Train;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class CoachPriceRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(CoachPrice coachPrice){
        entityManager.persist(coachPrice);
    }
    public List<CoachPrice> getAllCoachPrice(){
        String jpql = "Select t from CoachPrice t";
        TypedQuery<CoachPrice> query = entityManager.createQuery(jpql,CoachPrice.class);
        return query.getResultList();
    }
    public CoachPrice findById(UUID id){
        return entityManager.find(CoachPrice.class,id);
    }
    public void remove(CoachPrice coachPrice){
        entityManager.remove(coachPrice);
    }
}

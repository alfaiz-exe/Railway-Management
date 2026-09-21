package com.example.demo.repository;

import com.example.demo.model.Ticket;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TicketRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Ticket ticket){
        entityManager.persist(ticket);
    }
    public List<Ticket> getAll(){
        String jpql = "Select t From Ticket t";
        TypedQuery<Ticket> query = entityManager.createQuery(jpql,Ticket.class);
        return query.getResultList();
    }
    public Ticket findById(UUID id){
        return entityManager.find(Ticket.class,id);
    }
    public void remove(Ticket ticket){
        entityManager.remove(ticket);
    }
}

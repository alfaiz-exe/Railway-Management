package com.example.demo.repository;

import com.example.demo.model.Route;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RouteRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Route route){
        entityManager.persist(route);
    }
    public List<Route> getAllRoute(){
        String jpql = "Select t From Route t";
        TypedQuery<Route> query = entityManager.createQuery(jpql,Route.class);
        return query.getResultList();
    }
    public Route findById(UUID id){
        return entityManager.find(Route.class,id);
    }
    public void remove(Route route){
        entityManager.remove(route);
    }
}

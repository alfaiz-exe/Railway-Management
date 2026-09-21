package com.example.demo.repository;

import com.example.demo.model.Route;
import com.example.demo.model.RouteTime;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RouteTimeRepository {
@PersistenceContext
    private EntityManager entityManager;
public void save(RouteTime routeTime){
    entityManager.persist(routeTime);
}
public List<RouteTime> getAllRouteTime(){
    String jpql = "Select t from RouteTime t";
    TypedQuery<RouteTime> query = entityManager.createQuery(jpql,RouteTime.class);
    return query.getResultList();
}
public RouteTime findById(UUID id){
    return entityManager.find(RouteTime.class,id);
}
public void remove(RouteTime routeTime){
    entityManager.remove(routeTime);
}
}

package com.example.demo.repository;

import com.example.demo.model.Train;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TrainRepository {
      @PersistenceContext
      private EntityManager entityManager;
      // persist function is used for creation
      public void save(Train train){
          entityManager.persist(train);
      }
      //read
      public List<Train> getAllTrain(){
            String jpql = "Select t From Train t";
            TypedQuery <Train> query = entityManager.createQuery(jpql,Train.class);
            return query.getResultList();
      }
      public Train findById(UUID id)
      {
          return entityManager.find(Train.class,id);
      }
      //delete
      public void remove(Train train)
      {
          entityManager.remove(train);
      }

}

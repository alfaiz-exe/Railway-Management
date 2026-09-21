package com.example.demo.service;

import com.example.demo.model.CoachPrice;
import com.example.demo.repository.CoachPriceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CoachPriceService
{
    CoachPriceRepository coachPriceRepository;
    public CoachPriceService(CoachPriceRepository coachPriceRepository){
        this.coachPriceRepository = coachPriceRepository;
    }
    @Transactional
    public void create(CoachPrice coachPrice){
        coachPriceRepository.save(coachPrice);
    }
    @Transactional
    public CoachPrice findById(UUID id){
        return coachPriceRepository.findById(id);
    }
    @Transactional
    public List<CoachPrice> getAll(){
        return coachPriceRepository.getAllCoachPrice();
    }
    @Transactional
    public void update(CoachPrice coachPrice,UUID id){
        CoachPrice selectedCoachPrice = coachPriceRepository.findById(id);
        if (selectedCoachPrice == null){
            throw new RuntimeException("CoachPrice not found");
        }
        selectedCoachPrice.setCoachPrice(coachPrice.getCoachPrice());
        selectedCoachPrice.setCoachType(coachPrice.getCoachType());
        selectedCoachPrice.setTicket(coachPrice.getTicket());
    }
    @Transactional
    public void delete(UUID id){
        CoachPrice coachPrice = coachPriceRepository.findById(id);
        if (coachPrice == null){
            throw new RuntimeException("CoachPrice not found");
        }
        coachPriceRepository.remove(coachPrice);
    }
}

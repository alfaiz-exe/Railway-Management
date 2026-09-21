package com.example.demo.service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrainService {
    TrainRepository trainRepository;

    public TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }
    @Transactional
    public void create(Train train){
        trainRepository.save(train);
    }
    @Transactional
    public Train findById(UUID id) {
        return trainRepository.findById(id);
    }
    public List<Train> getAll(){
        return trainRepository.getAllTrain();
    }
    @Transactional
    public void update(Train train, UUID id){
        Train selectedTrain = trainRepository.findById(id);
        if (selectedTrain == null){
            throw new RuntimeException("Train not found");
        }
        selectedTrain.setId(train.getId());
        selectedTrain.setName(train.getName());
    }
    @Transactional
    public void delete(UUID id){
        Train train = trainRepository.findById(id);
        if (train == null){
            throw new RuntimeException("Train not found");
        }
        trainRepository.remove(train);
    }
}

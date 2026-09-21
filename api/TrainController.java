package com.example.demo.api;

import com.example.demo.model.Train;
import com.example.demo.service.TrainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/train")
public class TrainController {
    TrainService trainService;
    public TrainController(TrainService trainService){
        this.trainService = trainService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Train train){
        trainService.create(train);
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/{id}")
    public Optional<Train> findById(@PathVariable UUID id){
        return Optional.ofNullable(trainService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Train train,
                                              @PathVariable UUID id){
        trainService.update(train,id);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        trainService.delete(id);
        return ResponseEntity.ok("Done");
    }
    @GetMapping
    public List<Train> getAll(){
        return trainService.getAll();
    }
}

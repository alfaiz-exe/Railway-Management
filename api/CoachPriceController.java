package com.example.demo.api;

import com.example.demo.model.CoachPrice;
import com.example.demo.service.CoachPriceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/coachprice")
public class CoachPriceController {
    CoachPriceService coachPriceService;
    public CoachPriceController(CoachPriceService coachPriceService){
        this.coachPriceService = coachPriceService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CoachPrice coachPrice){
        coachPriceService.create(coachPrice);
        return ResponseEntity.ok("done");
    }
    @GetMapping("/{id}")
    public Optional<CoachPrice>findById(@PathVariable UUID id){
        return Optional.ofNullable(coachPriceService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody CoachPrice coachPrice,
                                             @PathVariable UUID id){
        coachPriceService.update(coachPrice,id);
        return ResponseEntity.ok("Done");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        coachPriceService.delete(id);
        return ResponseEntity.ok("Done");
    }
    @GetMapping
    public List<CoachPrice> getAll(){
        return coachPriceService.getAll();
    }
}

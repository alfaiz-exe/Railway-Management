package com.example.demo.api;

import com.example.demo.model.RouteTime;
import com.example.demo.service.RouteTimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/routetime")
public class RouteTimeController {
    RouteTimeService routeTimeService;
    public RouteTimeController (RouteTimeService routeTimeService){
        this.routeTimeService = routeTimeService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody RouteTime routeTime){
        routeTimeService.create(routeTime);
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/{id}")
    public Optional<RouteTime> findById(@PathVariable UUID id){
        return Optional.ofNullable(routeTimeService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody RouteTime routeTime,
                                         @PathVariable UUID id){
        routeTimeService.update(routeTime,id);
        return ResponseEntity.ok("Done");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        routeTimeService.delete(id);
        return ResponseEntity.ok("Done");
    }
    @GetMapping
    public List<RouteTime> getAll(){
        return routeTimeService.getAll();
    }
}

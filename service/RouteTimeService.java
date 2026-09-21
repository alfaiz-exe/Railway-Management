package com.example.demo.service;

import com.example.demo.model.RouteTime;
import com.example.demo.repository.RouteTimeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RouteTimeService {
    RouteTimeRepository routeTimeRepository;
    public RouteTimeService(RouteTimeRepository routeTimeRepository){
        this.routeTimeRepository = routeTimeRepository;
    }
    @Transactional
    public void create(RouteTime routeTime){
        routeTimeRepository.save(routeTime);
    }
    @Transactional
    public RouteTime findById(UUID id){
        return routeTimeRepository.findById(id);
    }
    @Transactional
    public List<RouteTime> getAll(){
        return routeTimeRepository.getAllRouteTime();
    }
    @Transactional
    public void update(RouteTime routeTime,UUID id){
        RouteTime selectedRouteTime = routeTimeRepository.findById(id);
        if (selectedRouteTime == null){
            throw new RuntimeException("Route time not found");
        }
        selectedRouteTime.setStartTime(routeTime.getStartTime());
        selectedRouteTime.setEndTime(routeTime.getEndTime());
        selectedRouteTime.setRoute(routeTime.getRoute());
    }
    @Transactional
    public void delete(UUID id){
        RouteTime routeTime = routeTimeRepository.findById(id);
        if (routeTime == null){
            throw new RuntimeException("Route time not found");
        }
    }
}

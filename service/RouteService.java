package com.example.demo.service;

import com.example.demo.model.Route;
import com.example.demo.repository.RouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RouteService {
    RouteRepository routeRepository;
    public RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }
    @Transactional
    public void create(Route route){
        routeRepository.save(route);
    }
    @Transactional
    public Route findById(UUID id){
        return routeRepository.findById(id);
    }
    @Transactional
    public List<Route> getAll(){
        return routeRepository.getAllRoute();
    }
    @Transactional
    public void update(Route route,UUID id){
        Route selectedRoute = routeRepository.findById(id);
        if (route == null){
            throw new RuntimeException("Route not found");
        }
        selectedRoute.setFromLocation(route.getFromLocation());
        selectedRoute.setToLocation(route.getToLocation());
        selectedRoute.setTrain(route.getTrain());
    }
    @Transactional
    public void delete(UUID id){
        Route route = routeRepository.findById(id);
        if (route == null){
            throw new RuntimeException("Route not found");
        }
        routeRepository.remove(route);
    }
}

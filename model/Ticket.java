package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.util.RouteMatcher;

import java.util.UUID;

@Entity
@Table(name = "ticket")
public class Ticket {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Id
    @GeneratedValue
    public UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id",nullable = false)
    public Train train;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id",nullable = false)
    public Route route;


}

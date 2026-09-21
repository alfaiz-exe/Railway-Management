package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "route")
public class Route {
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

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id",nullable = false)
    private Train train;
    @Column(name = "from_location")
    private String fromLocation;
    @Column(name = "to_location")
    private String toLocation;
}

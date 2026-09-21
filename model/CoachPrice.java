package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "coach_price")
public class CoachPrice {
    @Id
    @GeneratedValue
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getCoachType() {
        return coachType;
    }

    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    public Integer getCoachPrice() {
        return coachPrice;
    }

    public void setCoachPrice(Integer coachPrice) {
        this.coachPrice = coachPrice;
    }

    //universal unique identifier
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id",nullable = false)
    private Ticket ticket;
    @Column(name = "coach_type")
    private String coachType;
    @Column(name = "coach_price")
    private Integer coachPrice;
    //this constructor is used create a train object
}

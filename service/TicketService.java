package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {
    TicketRepository ticketRepository;
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }
    @Transactional
    public void create(Ticket ticket){
        ticketRepository.save(ticket);
    }
    @Transactional
    public Ticket findById(UUID id){
        return ticketRepository.findById(id);
    }
    @Transactional
    public List<Ticket> getAll (){
        return ticketRepository.getAll();
    }
    @Transactional
    public void update(Ticket ticket,UUID id){
        Ticket selectedTicket = ticketRepository.findById(id);
        if (selectedTicket == null){
            throw new RuntimeException("ticket not found");
        }
        selectedTicket.setRoute(ticket.getRoute());
        selectedTicket.setTrain(ticket.getTrain());
    }
    @Transactional
    public void delete(UUID id){
        Ticket ticket = ticketRepository.findById(id);
        if (ticket == null){
            throw new RuntimeException("Ticket not found");
        }
        ticketRepository.remove(ticket);
    }
}

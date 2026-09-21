package com.example.demo.api;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Ticket ticket){
        ticketService.create(ticket);
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/{id}")
    public Optional<Ticket> findById(@PathVariable UUID id){
        return Optional.ofNullable(ticketService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Ticket ticket,@PathVariable UUID id){
        ticketService.update(ticket,id);
        return ResponseEntity.ok("Done");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        ticketService.delete(id);
        return ResponseEntity.ok("Done");
    }
}

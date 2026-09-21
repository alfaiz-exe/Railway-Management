package com.example.demo.api;

import com.example.demo.model.Transactions;
import com.example.demo.service.TransactionService;
import org.hibernate.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    TransactionService transactionService;
    public TransactionController (TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Transactions transactions){
        transactionService.create(transactions);
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/{id}")
    public Optional<Transactions> findById(@PathVariable UUID id){
        return Optional.ofNullable(transactionService.findById(id));
    }
    @PutMapping ("/{id}")
    public ResponseEntity<String> update(@PathVariable UUID id,
                                         @RequestBody Transactions transactions){
        transactionService.update(transactions,id);
        return ResponseEntity.ok("DONE");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        transactionService.delete(id);
        return ResponseEntity.ok("Done");
    }
    @GetMapping
    public List<Transactions> getAll(){
        return transactionService.getAll();
    }
}

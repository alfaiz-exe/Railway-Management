package com.example.demo.service;

import com.example.demo.model.Transactions;
import com.example.demo.repository.TransactionRepository;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    @Transactional
    public void create (Transactions transactions){
        transactionRepository.save(transactions);
    }
    @Transactional
    public Transactions findById(UUID id){
        return transactionRepository.findById(id);
    }
    @Transactional
    public List<Transactions> getAll(){
        return transactionRepository.getAllTransaction();
    }
    @Transactional
    public void update(Transactions transactions,UUID id){
        Transactions selectedTransaction = transactionRepository.findById(id);
        if (selectedTransaction == null){
            throw new RuntimeException("Transaction not found");
        }
        selectedTransaction.setTicket(transactions.getTicket());
        selectedTransaction.setTimeOfTransaction(transactions.getTimeOfTransaction());
        selectedTransaction.setTransactionAmount(transactions.getTransactionAmount());
        selectedTransaction.setUser(transactions.getUser());
    }
    @Transactional
    public void delete(UUID id){
        Transactions  transactions = transactionRepository.findById(id);
        if (transactions == null){
            throw new RuntimeException("Transactions not found");
        }
        transactionRepository.remove(transactions);
    }
}

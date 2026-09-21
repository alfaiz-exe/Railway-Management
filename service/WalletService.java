package com.example.demo.service;

import com.example.demo.model.Wallet;
import com.example.demo.repository.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WalletService {
    WalletRepository walletRepository;
    public WalletService (WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }
    @Transactional
    public void create(Wallet wallet){
        walletRepository.save(wallet);
    }
    @Transactional
    public Wallet findById(UUID id){
        return walletRepository.findById(id);
    }
    @Transactional
    public List<Wallet> getAll(){
        return walletRepository.getAll();
    }
    @Transactional
    public void update(Wallet wallet,UUID id){
        Wallet selectedWallet = walletRepository.findById(id);
        if (selectedWallet == null){
            throw new RuntimeException("Wallet not found");
        }
        selectedWallet.setAvailableBalance(wallet.getAvailableBalance());
        selectedWallet.setUser(wallet.getUser());
    }
}

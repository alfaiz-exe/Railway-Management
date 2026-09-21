package com.example.demo.api;

import com.example.demo.model.Wallet;
import com.example.demo.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    WalletService walletService;
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Wallet wallet){
        walletService.create(wallet);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/{id}")
    public Optional<Wallet> findById(@PathVariable UUID id){
        return Optional.ofNullable(walletService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Wallet wallet,
                                               @PathVariable UUID id){
        walletService.update(wallet,id);
        return ResponseEntity.ok("ok");
    }
    @GetMapping
    public List<Wallet> getAll(){
        return walletService.getAll();
    }
}

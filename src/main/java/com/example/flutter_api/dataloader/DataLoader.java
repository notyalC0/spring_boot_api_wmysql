package com.example.flutter_api.dataloader;

import com.example.flutter_api.models.Moeda;
import com.example.flutter_api.repositorys.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MoedaRepository moedaRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (moedaRepository.count() > 0 ) return;

        moedaRepository.saveAll(List.of(
                new Moeda("BTC",  "Bitcoin",  "images/bitcoin.png",   340971.56),
                new Moeda("ADA",  "Cardano",  "images/cardano.png",   1.50),
                new Moeda("ETH",  "Ethereum", "images/ethereum.png",  23000.00),
                new Moeda("LTC",  "Litecoin", "images/litecoin.png",  120.00),
                new Moeda("USDC", "USD Coin", "images/usdcoin.png",   1.00),
                new Moeda("XRP",  "Xrp",      "images/xrp.png",       1.25)
        ));

        System.out.println("Moedas inseridas!");
    }

}

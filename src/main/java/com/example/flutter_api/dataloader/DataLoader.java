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
                new Moeda("XRP",  "Xrp",      "images/xrp.png",       1.25),
                new Moeda("BNB",   "Binance Coin",      "images/bnb.png",                1500.00),
                new Moeda("SOL",   "Solana",            "images/sol.png",                  800.00),
                new Moeda("DOT",   "Polkadot",          "images/dot.png",                   35.00),
                new Moeda("DOGE",  "Dogecoin",          "images/doge.png",                   0.80),
                new Moeda("AVAX",  "Avalanche",         "images/avax.png",                 180.00),
                new Moeda("MATIC", "Polygon",           "images/matic.png",                  4.50),
                new Moeda("USDT",  "Tether",            "images/usdt.png",                   1.00),
                new Moeda("LINK",  "Chainlink",         "images/link.png",                  80.00),
                new Moeda("UNI",   "Uniswap",           "images/uni.png",                   45.00),
                new Moeda("ATOM",  "Cosmos",            "images/atom.png",                  55.00),
                new Moeda("XLM",   "Stellar",           "images/xlm.png",                    0.65),
                new Moeda("ALGO",  "Algorand",          "images/algo.png",                   1.20),
                new Moeda("VET",   "VeChain",           "images/vet.png",                    0.05),
                new Moeda("ICP",   "Internet Computer", "images/icp.png",                   60.00),
                new Moeda("FIL",   "Filecoin",          "images/fil.png",                   25.00),
                new Moeda("THETA", "Theta Network",     "images/theta.png",                 12.00),
                new Moeda("TRX",   "Tron",              "images/trx.png",                    0.15),
                new Moeda("ETC",   "Ethereum Classic",  "images/etc.png",                   35.00),
                new Moeda("XMR",   "Monero",            "images/xmr.png",                  900.00),
                new Moeda("AAVE",  "Aave",              "images/aave.png",                 450.00),
                new Moeda("GRT",   "The Graph",         "images/grt.png",                    1.80),
                new Moeda("SAND",  "The Sandbox",       "images/sand.png",                   5.00),
                new Moeda("MANA",  "Decentraland",      "images/mana.png",                   3.50)
        ));

        System.out.println("Moedas inseridas!");
    }

}

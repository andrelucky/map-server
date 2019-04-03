package com.map.nbio.mapserver.service;

import com.map.nbio.mapserver.model.Stock;
import com.map.nbio.mapserver.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.text.ParseException;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Flux<Stock> findAll(){
        return stockRepository.findAll();
    }
}

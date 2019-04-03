package com.map.nbio.mapserver.controller;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.model.InvoiceStorePerDay;
import com.map.nbio.mapserver.model.Stock;
import com.map.nbio.mapserver.repository.InvoiceStorePerDayRepository;
import com.map.nbio.mapserver.service.InvoiceService;
import com.map.nbio.mapserver.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("api/stock/")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(path = "all")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Flux<Stock> all(){
        return stockService.findAll();
    }
}

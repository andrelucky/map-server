package com.map.nbio.mapserver.controller;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;

@RestController
@RequestMapping("api/invoice/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path = "all",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Flux<Invoice> all() throws ParseException {
        return invoiceService.findAll();

//        Flux<Invoice> eventFlux = Flux.fromStream(Stream.generate(Invoice::new));
//
//        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(5));
//
//        return invoiceService.findAll().switchIfEmpty(Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1));


//        Flux.interval(Duration.ofSeconds(1))
//                .onBackpressureDrop().map(new Invoice()).subscribe(invoiceService.findAll());
//        Flux<Invoice> eventFlux = Flux.fromStream(Stream.generate(Invoice::new));
//
//        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(
//                5
//        ));
//
//
//        return
//                Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1);
    }

    @PostMapping(path = "save")
    public Mono<Invoice> save(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }
}

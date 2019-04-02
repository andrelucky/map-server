package com.map.nbio.mapserver.controller;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.text.ParseException;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/invoice/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path = "all",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Flux<Invoice> all() throws ParseException {
//        return invoiceService.findAll();
        Flux<Invoice> eventFlux = Flux.fromStream(Stream.generate(Invoice::new));

        Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(
                30
        ));


        return
                Flux.zip(eventFlux, durationFlux).map(Tuple2::getT1);
    }

    @PostMapping(path = "save")
    public Mono<Invoice> save(@RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }
}

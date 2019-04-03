package com.map.nbio.mapserver.controller;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.model.InvoiceStorePerDay;
import com.map.nbio.mapserver.repository.InvoiceStorePerDayRepository;
import com.map.nbio.mapserver.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("api/invoice/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceStorePerDayRepository invoiceStorePerDayRepository;

    @GetMapping(path = "all",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Flux<Invoice> all() throws ParseException {
        return invoiceService.findAll();
    }

    @PostMapping(path = "save")
    public Mono<Invoice> save(@Valid @RequestBody Invoice invoice) {
        return invoiceService.save(invoice);
    }

    @PostMapping(path = "saves")
    public Mono<InvoiceStorePerDay> saveHis(@Valid @RequestBody InvoiceStorePerDay invoice) {
        return invoiceStorePerDayRepository.save(invoice);
    }
}

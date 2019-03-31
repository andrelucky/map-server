package com.map.nbio.mapserver.service;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.Calendar;

@Service
public class InvoiceService {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Mono<Invoice> save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Flux<Invoice> findAll() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return invoiceRepository.findAllByDateGreaterThanEqual(cal.getTime());
    }
}

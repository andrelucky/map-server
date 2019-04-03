package com.map.nbio.mapserver.service;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.model.InvoiceStorePerDay;
import com.map.nbio.mapserver.repository.InvoiceRepository;
import com.map.nbio.mapserver.repository.InvoiceStorePerDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class InvoiceStorePerDayService {

    @Autowired
    private InvoiceStorePerDayRepository invoiceStorePerDayRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Mono<InvoiceStorePerDay> save(InvoiceStorePerDay invoice) {
        return invoiceStorePerDayRepository.findInvoiceByDateAndStoreCode(invoice.getDate(),invoice.getStoreCode()).doOnSuccess(invoiceStorePerDay -> {
            invoice.setId(invoiceStorePerDay.getId());
            invoice.setTotalInvoice(invoiceStorePerDay.getTotalInvoice()+1);
            invoiceStorePerDayRepository.save(invoice).subscribe();
        });
//        return invoiceStorePerDayRepository.save(invoice);
    }

    public Flux<InvoiceStorePerDay> findAll() throws ParseException {
        return invoiceStorePerDayRepository.findAllByDateGreaterThanEqual(Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
    }
}

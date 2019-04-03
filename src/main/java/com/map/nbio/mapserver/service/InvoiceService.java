package com.map.nbio.mapserver.service;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.model.InvoiceStorePerDay;
import com.map.nbio.mapserver.repository.InvoiceRepository;
import com.map.nbio.mapserver.repository.InvoiceStorePerDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceStorePerDayService invoiceStorePerDayService;

    public Mono<Invoice> save(Invoice invoice) {
        invoice.setCreatedDate(new Date());

        return invoiceRepository.save(invoice)
                .doOnSuccess(invoice1 -> {
//            invoiceStorePerDayRepository.findInvoiceByDateAndStoreCode(invoice1.getDate(), invoice1.getStoreCode()).hasElement().flatMap(invoiceStorePerDay -> {

//                    Mono<InvoiceStorePerDay> dayMono = invoiceStorePerDayRepository.findInvoiceByDateAndStoreCode(invoice1.getDate(), invoice1.getStoreCode());
//                if (invoiceStorePerDay != null){
                    InvoiceStorePerDay invoiceStorePerDay = new InvoiceStorePerDay();
                    invoiceStorePerDay.setStoreCode(invoice1.getStoreCode());
                    invoiceStorePerDay.setStoreName(invoice1.getStoreName());
                    invoiceStorePerDay.setDate(invoice1.getDate());
//                }

                invoiceStorePerDay.setTotalInvoice(1);
                invoiceStorePerDay.setTotalPrice(invoice1.getTotalPrice());
                invoiceStorePerDayService.save(invoiceStorePerDay).subscribe();
//                return Mono.just(invoiceStorePerDay);
//            }
//            );
        });
    }

    public Flux<Invoice> findAll() throws ParseException {
        return invoiceRepository.findDistinctByDateGreaterThanEqual(Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
    }
}

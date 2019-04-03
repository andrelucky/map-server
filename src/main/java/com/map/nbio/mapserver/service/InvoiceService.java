package com.map.nbio.mapserver.service;

import com.map.nbio.mapserver.model.Invoice;
import com.map.nbio.mapserver.model.Stock;
import com.map.nbio.mapserver.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.util.Date;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private MongoOperations mongoOperations;

    public Mono<Invoice> save(Invoice invoice) {
        invoice.setCreatedDate(new Date());

        return invoiceRepository.save(invoice)
                .doOnSuccess(invoice1 -> {
                    invoice1.getInvoiceDetails().forEach(invoiceDetail -> {
                        Query query = new Query();
                        query.addCriteria(Criteria.where("itemCode").is(invoiceDetail.getItemCode()));

                        Stock stock = mongoOperations.findOne(query, Stock.class);

                        Update update = new Update();
                        update.set("stock", stock.getStock() - invoiceDetail.getQuantity());

                        mongoOperations.updateFirst(query, update, Stock.class);
                    });

                });
    }

    public Flux<Invoice> findAll() throws ParseException {
        return invoiceRepository.findAllByCreatedDateGreaterThanEqual(new Date());
//        return invoiceRepository.findAllByDateGreaterThanEqual(Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
    }
}

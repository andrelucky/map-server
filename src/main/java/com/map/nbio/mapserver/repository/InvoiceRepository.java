package com.map.nbio.mapserver.repository;

import com.map.nbio.mapserver.model.Invoice;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Repository
public interface InvoiceRepository extends ReactiveMongoRepository<Invoice, String> {

    @Tailable
    Flux<Invoice> findAllByDateGreaterThanEqual(Integer date);

    @Tailable
    Flux<Invoice> findAllByCreatedDateGreaterThanEqual(Date date);

    @Query()
    Mono<Invoice> findInvoiceByDate(Integer date);
}
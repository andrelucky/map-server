package com.map.nbio.mapserver.repository;

import com.map.nbio.mapserver.model.InvoiceStorePerDay;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface InvoiceStorePerDayRepository extends ReactiveMongoRepository<InvoiceStorePerDay, String> {

    @Tailable
    Flux<InvoiceStorePerDay> findAllByDateGreaterThanEqual(Integer date);

    @Query()
    Mono<InvoiceStorePerDay> findInvoiceByDateAndStoreCode(Integer date, String storeCode);
}

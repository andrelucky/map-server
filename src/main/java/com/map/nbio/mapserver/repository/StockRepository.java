package com.map.nbio.mapserver.repository;

import com.map.nbio.mapserver.model.Stock;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StockRepository extends ReactiveMongoRepository<Stock, String> {
}

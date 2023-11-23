package org.sid.reactifspring.dao;

import org.sid.reactifspring.entities.Societe;
import org.sid.reactifspring.entities.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction,String> {
    public Flux<Transaction> findBySociete(Societe societe);
}

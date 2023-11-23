package org.sid.reactifspring.dao;

import org.sid.reactifspring.entities.Societe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SocieteRepository extends ReactiveMongoRepository<Societe,String> {
}

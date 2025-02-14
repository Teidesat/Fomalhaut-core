package com.hyperspacegroup.fomalhaut.core.tests;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ReactiveMongoRepository<Log, String> {
}
package com.hyperspacegroup.fomalhaut.core.model.dao;

import com.hyperspacegroup.fomalhaut.core.model.Log;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ReactiveMongoRepository<Log, String> {
}
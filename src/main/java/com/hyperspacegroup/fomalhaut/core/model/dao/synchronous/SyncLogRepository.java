package com.hyperspacegroup.fomalhaut.core.model.dao.synchronous;

import com.hyperspacegroup.fomalhaut.core.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyncLogRepository extends MongoRepository<Log, String> {
}
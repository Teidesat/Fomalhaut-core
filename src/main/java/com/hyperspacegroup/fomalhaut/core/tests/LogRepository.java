package com.hyperspacegroup.fomalhaut.core.tests;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends ReactiveCrudRepository<Log, Long> {
}
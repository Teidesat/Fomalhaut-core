package com.hyperspacegroup.fomalhaut.core.tests;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LogController {

  @Autowired
  private LogRepository logRepository;

  public Flux<Log> findAll() {
    return logRepository.findAll();
  }

  public Mono<Log> findById(String id) {
    return logRepository.findById(id)
        .switchIfEmpty(Mono.error(new RuntimeException("Log not found")));
  }

  public Mono<Log> save(Log log) {
    return logRepository.save(Log.builder()
        .title(log.getTitle())
        .body(log.getBody())
        .dateTime(LocalDateTime.now())
        .build());
  }

  public Mono<Log> update(String id, Log log) {
    return this.findById(id)
        .flatMap(existingLog -> {
          BeanUtils.copyProperties(log, existingLog, "id");
          return this.logRepository.save(existingLog);
        })
        .switchIfEmpty(Mono.error(new RuntimeException("Log not found")));
  }

  public void deleteById(String id) {
    logRepository.deleteById(id);
  }

  public void deleteAllLogsBeforeDate() {
    logRepository.deleteAll();
  }

}
package com.hyperspacegroup.fomalhaut.core.tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/logs")
public class LogView {
  private LogController logController;

  LogView(@Autowired LogController logController) {
    this.logController = logController;
  }

  @GetMapping
  public Flux<Log> getAll() {
    return logController.findAll();
  }

  @GetMapping("/{id}")
  public Mono<Log> getLogById(@PathVariable String id) {
    return logController.findById(id);
  }

  @PostMapping
  public Mono<Log> createLog(@RequestBody Log log) {
    return logController.save(log);
  }

  @PutMapping("/{id}")
  public Mono<Log> createLog(@PathVariable String id, @RequestBody Log log) {
    return logController.update(id, log);
  }

  @DeleteMapping("/{id}")
  public void deleteLog(@PathVariable String id) {
    logController.deleteById(id);
  }

  @DeleteMapping
  public void deleteAllLogsBeforeDate() {
    logController.deleteAllLogsBeforeDate();
  }
}
package com.sekl.demo.controllers;

import com.sekl.demo.entities.DefaultEntity;
import com.sekl.demo.services.DefaultService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
public class DefaultController<T extends DefaultEntity> {
  private final DefaultService<T> service;

  @GetMapping
  public List<T> getAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public T getById(@PathVariable Long id) {
    return service.findById(id).orElse(null);
  }

  @PostMapping
  public T create(@RequestBody T t) {
    return service.save(t);
  }

  @PutMapping("/{id}")
  public T update(@PathVariable Long id, @RequestBody T t) {
    return service.save(id, t);
  }

  @DeleteMapping("/{id}")
  public void detete(@PathVariable Long id) {
    service.delete(id);
  }

  @GetMapping("/version")
  public String version(){
    return service.getVersion();
  }
}

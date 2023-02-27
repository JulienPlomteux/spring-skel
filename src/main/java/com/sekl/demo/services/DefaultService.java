package com.sekl.demo.services;

import com.sekl.demo.entities.DefaultEntity;
import com.sekl.demo.repositories.DefaultRepository;
import java.util.List;
import java.util.Optional;
import lombok.Data;

@Data
public class DefaultService<T extends DefaultEntity> {

  private final DefaultRepository<T> repo;

  public List<T> findAll() { return repo.findAll(); }

  public Optional<T> findById(Long id) { return repo.findById(id); }

  public T save(T t) { return repo.save(t); }

  public T save(Long id, T t) {
    t.setId(id);
    return repo.save(t);
  }

  public void delete(Long id) { repo.deleteById(id); }

  public String getVersion() {
    return "3";
  }
}

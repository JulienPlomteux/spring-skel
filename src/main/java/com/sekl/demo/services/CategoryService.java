package com.sekl.demo.services;

import com.sekl.demo.entities.Category;
import com.sekl.demo.repositories.DefaultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CategoryService extends DefaultService<Category> {
	public CategoryService(DefaultRepository<Category> repo) {
		super(repo);
	}

}

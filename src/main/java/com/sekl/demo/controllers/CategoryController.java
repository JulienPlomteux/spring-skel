package com.sekl.demo.controllers;

import com.sekl.demo.entities.Category;
import com.sekl.demo.services.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends DefaultController<Category> {

  public CategoryController(DefaultService<Category> service) {
    super(service);
  }
}

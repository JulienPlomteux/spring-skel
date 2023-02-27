package com.sekl.demo.controllers;

import com.sekl.demo.entities.Category;
import com.sekl.demo.utils.EntityUtil;
import java.util.List;

//@SpringBootTest
//@AutoConfigureMockMvc
//@TestInstance(Lifecycle.PER_CLASS)
//@Slf4j
//@Transactional
public class CategoryControllerTest extends DefaultControllerTest<Category> {
  final String CATEGORY_ENDPOINT = "/api/v1/categories";

  @Override
  public Class<Category> getEntityClass() {
    return Category.class;
  }

  @Override
  public Category modifyEntity(Category t) {
    return t.toBuilder().name("qwe").build();
  }

  @Override
  public String getEndpoint() {
    return CATEGORY_ENDPOINT;
  }

  @Override
  public Category generateEntity() {
    return EntityUtil.generateCategoryEntity();
  }

  @Override
  public Category generateInvalidEntity() {
    return Category.builder().build();
  }

  @Override
  public List<Category> generateEntities(int size) {
    return EntityUtil.generateCategoryEntities(size);
  }
}

package com.sekl.demo.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends DefaultEntity {

  @NotNull String name;

  @NotNull String sku;

  @ManyToMany List<Category> categories;

  @Builder.Default boolean display = true;
}

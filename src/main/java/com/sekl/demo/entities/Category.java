package com.sekl.demo.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Category extends DefaultEntity {

  @NotNull String name;

  @Builder.Default boolean display = true;
}

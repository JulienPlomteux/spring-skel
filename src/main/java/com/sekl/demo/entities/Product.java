package com.sekl.demo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends DefaultEntity {

	@NotNull
	String name;

	@NotNull
	String sku;

	@ManyToMany
	List<Category> categories;

	@Builder.Default
	boolean display = true;
}

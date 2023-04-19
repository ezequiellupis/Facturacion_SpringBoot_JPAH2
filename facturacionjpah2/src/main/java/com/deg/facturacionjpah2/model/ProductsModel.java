package com.deg.facturacionjpah2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Table(name = "Products")
public class ProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotNull
	@Length(min=5)
    private String description;
	@NotNull
	@Column(unique = true)
	@Pattern(regexp = "^[A-Za-z]{4}\\d{4}$")
    private String code;
	@NotNull
	@Min(0)
    private Integer stock;
	@NotNull
	@Min(0)
    private Double price;
	@NotNull
	private boolean status =true;
}

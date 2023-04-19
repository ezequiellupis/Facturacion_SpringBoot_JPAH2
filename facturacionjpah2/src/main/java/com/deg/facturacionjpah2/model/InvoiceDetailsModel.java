package com.deg.facturacionjpah2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Entity
@Data
@Table(name = "Invoice_Details")
public class InvoiceDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceDetailsId;
	@NotNull
	@Min(0)
    private Integer amount;
	@NotNull
	@Min(0)
    private Double price;
	@JsonBackReference
    @ManyToOne
    @JoinColumn(name="invoice_id")
    private InvoiceModel invoice;
	@NotNull
	@Min(0)
	private Double productPrice;
	@ManyToOne
    @JoinColumn(name="product_id")
    private ProductsModel product;
	@NotNull
	private boolean status =true;
	@Transient
	private long invoiceId;
}

package com.deg.facturacionjpah2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
@Table(name = "Invoice")
public class InvoiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotNull
    private LocalDate createdAt = LocalDate.now();
	@NotNull
	@Min(0)
    private Double total=0.00;

	@JsonBackReference("clientsModel")
    @ManyToOne
    @JoinColumn(name="client_id")
     private ClientsModel clients;
	@NotNull
	private boolean status =true;
	@JsonManagedReference
	@OneToMany(mappedBy = "invoice")
	private List<InvoiceDetailsModel> invoiceDetails;

}

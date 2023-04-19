package com.deg.facturacionjpah2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import java.util.List;
@Entity
@Data
@Table(name = "clients")
public class ClientsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@NotNull
	@Length(min=3)
	@Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
	@NotNull
	@Length(min=5)
	@Pattern(regexp = "^[a-zA-Z]+$")
    private String lastname;
    @NotNull
	@Length(min=8)
	@Pattern(regexp = "^[0-9]+$")
	@Column(unique = true, name="docnumber")
	private String docNumber;
	@NotNull
	private boolean status =true;

	// RELACION
	@JsonManagedReference("clientsModel")
	@OneToMany(mappedBy = "clients")
	private List<InvoiceModel> invoice;

}

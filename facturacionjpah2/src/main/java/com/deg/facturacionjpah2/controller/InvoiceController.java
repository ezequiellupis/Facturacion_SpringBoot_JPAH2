package com.deg.facturacionjpah2.controller;

import com.deg.facturacionjpah2.model.InvoiceModel;
import com.deg.facturacionjpah2.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="api/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	@PostMapping(path = "/")
	public ResponseEntity<InvoiceModel> create(@RequestBody InvoiceModel invoice) throws Exception {
		return new ResponseEntity<>(this.invoiceService.create(invoice), HttpStatus.OK);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<InvoiceModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.invoiceService.findById(id), HttpStatus.OK);
	}
	@GetMapping(path = "/")
	public ResponseEntity<List<InvoiceModel>> findAll(){
		return new ResponseEntity<>(this.invoiceService.findAll(), HttpStatus.OK);
	}
}

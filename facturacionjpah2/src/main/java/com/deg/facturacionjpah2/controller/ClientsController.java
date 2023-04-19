package com.deg.facturacionjpah2.controller;

import com.deg.facturacionjpah2.model.ClientsModel;
import com.deg.facturacionjpah2.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="api/clients")
public class ClientsController {
	@Autowired
	private ClientsService clientsService;
	@PostMapping(path = "/")
		public ResponseEntity<ClientsModel> create(@RequestBody ClientsModel client) throws Exception {
		return new ResponseEntity<>(this.clientsService.create(client), HttpStatus.OK);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<ClientsModel> update(@RequestBody ClientsModel client, @PathVariable Long id) throws Exception {
		return new ResponseEntity<>(this.clientsService.update(client,id), HttpStatus.OK);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<ClientsModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.clientsService.findById(id), HttpStatus.OK);
	}
	@GetMapping(path = "/doc/{docNumber}")
	public ResponseEntity<ClientsModel> findById(@PathVariable String docNumber) throws Exception {

		return new ResponseEntity<>(this.clientsService.findByDocNumber(docNumber), HttpStatus.OK);
	}
	@GetMapping(path = "/")
	public ResponseEntity<List<ClientsModel>> findAll(){
		return new ResponseEntity<>(this.clientsService.findAll(), HttpStatus.OK);
	}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
		clientsService.delete(id);
		return ResponseEntity.ok("Cliente " + id + " eliminado correctamente.");
	}
}

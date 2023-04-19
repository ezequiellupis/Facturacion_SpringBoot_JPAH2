package com.deg.facturacionjpah2.controller;

import com.deg.facturacionjpah2.model.ProductsModel;
import com.deg.facturacionjpah2.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(path="api/products")
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	@PostMapping(path = "/")
	public ResponseEntity<ProductsModel> create(@RequestBody ProductsModel product) throws Exception {
		return new ResponseEntity<>(this.productsService.create(product), HttpStatus.OK);
	}
	@PutMapping(path = "/{id}")
	public ResponseEntity<ProductsModel> update(@RequestBody ProductsModel product, @PathVariable Long id) throws Exception {
		return new ResponseEntity<>(this.productsService.update(product,id), HttpStatus.OK);
	}
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductsModel> findById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<>(this.productsService.findById(id), HttpStatus.OK);
	}
	@GetMapping(path = "/code/{code}")
	public ResponseEntity<ProductsModel> findByCode (@PathVariable String code) throws Exception {

		return new ResponseEntity<>(this.productsService.findByCode(code), HttpStatus.OK);
	}
	@GetMapping(path = "/")
	public ResponseEntity<List<ProductsModel>> findAll(){
		return new ResponseEntity<>(this.productsService.findAll(), HttpStatus.OK);
	}
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) throws Exception{
		productsService.delete(id);
		return ResponseEntity.ok("Producto " + id + " eliminado correctamente.");
	}
}

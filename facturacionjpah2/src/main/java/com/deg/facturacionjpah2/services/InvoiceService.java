package com.deg.facturacionjpah2.services;

import com.deg.facturacionjpah2.model.InvoiceDetailsModel;
import com.deg.facturacionjpah2.model.InvoiceModel;
import com.deg.facturacionjpah2.exception.IdNotValidException;
import com.deg.facturacionjpah2.exception.InsufficientStockException;
import com.deg.facturacionjpah2.exception.NotFoundException;
import com.deg.facturacionjpah2.repository.InvoiceRepository;
import com.deg.facturacionjpah2.repository.ProductsRepository;
import com.deg.facturacionjpah2.validator.InvoiceValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private InvoiceDetailsService invoiceDetailsService;
	@Autowired
	private ProductsService productsService;
	@Autowired
	private ProductsRepository productsRepository;

	//Método para crear invoice.
	public InvoiceModel create(InvoiceModel newInvoice) throws Exception {

		InvoiceValidator.invoiceValidator(newInvoice);

		newInvoice.setCreatedAt(LocalDate.now());

		for(int i =0; i<newInvoice.getInvoiceDetails().size();i++){

			InvoiceDetailsModel invoiceDetail=newInvoice.getInvoiceDetails().get(i);

			if(invoiceDetail.getAmount()>productsRepository.findById(invoiceDetail.getProduct().getId()).orElseThrow(() ->new NotFoundException("El producto seleccionado no existe.")).getStock()){
				log.info("Stock insuficiente");
				throw new InsufficientStockException("Stock insuficiente");

			}
		}

		InvoiceModel createdInvoice = this.invoiceRepository.save(newInvoice);

		double totalParcial=0;

		for(int i =0; i<newInvoice.getInvoiceDetails().size();i++){

			InvoiceDetailsModel newInvoiceDetail=newInvoice.getInvoiceDetails().get(i);

			newInvoiceDetail.setInvoiceId(createdInvoice.getId());

			newInvoiceDetail.setProduct(productsRepository.findById(newInvoiceDetail.getProduct().getId()).orElseThrow(() ->new NotFoundException("El producto seleccionado no existe.")));

			invoiceDetailsService.create(newInvoiceDetail);

			totalParcial+=newInvoiceDetail.getPrice();

			productsService.subtractStock(newInvoiceDetail);
		}

		createdInvoice.setTotal(totalParcial);

		this.invoiceRepository.save(createdInvoice);

		return createdInvoice;

	}

	// Método para buscar un invoice por el ID.
	public InvoiceModel findById(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<InvoiceModel> invoiceOp = this.invoiceRepository.findById(id);

		if (invoiceOp.isEmpty()){
			log.info("El invoice con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El invoice que intenta solicitar no existe.");
		}else {
			return invoiceOp.get();
		}
	}

	//Método para buscar todos los invoices.
	public List<InvoiceModel> findAll(){
		return this.invoiceRepository.findAll();
	}
}

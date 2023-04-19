package com.deg.facturacionjpah2.services;

import com.deg.facturacionjpah2.model.InvoiceDetailsModel;
import com.deg.facturacionjpah2.exception.NotFoundException;
import com.deg.facturacionjpah2.repository.InvoiceDetailsRepository;
import com.deg.facturacionjpah2.repository.InvoiceRepository;
import com.deg.facturacionjpah2.validator.InvoiceDetailsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class InvoiceDetailsService {
	@Autowired
	private InvoiceDetailsRepository invoiceDetailsRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;

	//Método para crear invoice details.
	public InvoiceDetailsModel create(InvoiceDetailsModel newInvoiceDetail) throws Exception {

			newInvoiceDetail.setInvoice(invoiceRepository.findById(newInvoiceDetail.getInvoiceId()).orElseThrow(() ->new NotFoundException("El invoice seleccionado no existe.")));

			double currentPrice = newInvoiceDetail.getProduct().getPrice();

			newInvoiceDetail.setProductPrice(currentPrice);

			newInvoiceDetail.setPrice(currentPrice * newInvoiceDetail.getAmount());

			InvoiceDetailsValidator.invoiceDetailsValidator(newInvoiceDetail);

			return this.invoiceDetailsRepository.save(newInvoiceDetail);
	}

}

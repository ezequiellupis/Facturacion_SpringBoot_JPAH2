package com.deg.facturacionjpah2.validator;

import com.deg.facturacionjpah2.model.InvoiceDetailsModel;
import com.deg.facturacionjpah2.exception.MinException;
import com.deg.facturacionjpah2.exception.NullException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvoiceDetailsValidator {

	public static void invoiceDetailsValidator(InvoiceDetailsModel newInvoiceDetail) throws Exception{

		if(newInvoiceDetail.getAmount() == null){
			log.info("La cantidad comprada no puede estar vacía");
			throw new NullException("La cantidad comprada no puede estar vacía");
		}
		if(newInvoiceDetail.getPrice()==null){
			log.info("El precio no puede estar vacío");
			throw new NullException("El precio no puede estar vacío");
		}
		if(newInvoiceDetail.getAmount()<0){
			log.info("La cantidad comprada no puede ser un número negativo");
			throw new MinException("La cantidad comprada no puede ser un número negativo");
		}
		if(newInvoiceDetail.getPrice()<0){
			log.info("La precio no puede ser un número negativo");
			throw new MinException("La precio no puede ser un número negativo");
		}
	}
}

package com.deg.facturacionjpah2.validator;

import com.deg.facturacionjpah2.exception.TooShortException;
import com.deg.facturacionjpah2.model.ProductsModel;
import com.deg.facturacionjpah2.exception.MinException;
import com.deg.facturacionjpah2.exception.NullException;
import com.deg.facturacionjpah2.exception.WrongCodeException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ProductsValidator {
	public static void productsValidator(ProductsModel newProduct) throws Exception{
		validateCode(newProduct.getCode());
		validateDescription(newProduct.getDescription());
		validateStock(newProduct.getStock());
		validatePrice(newProduct.getPrice());
	}

	private static void validateCode(String code) throws WrongCodeException {
		if(!code.matches("^[A-Za-z]{4}\\d{4}$")){
			log.info("El código ingresado debe ser alfanumerico");
			throw new WrongCodeException("El código ingresado debe ser alfanumérico");
		}
	}

	private static void validateDescription(String description) throws NullException,TooShortException  {
		if(description.isEmpty()){
			log.info("La descripción no puede estar vacía");
			throw new NullException("La descripción no puede estar vacía");
		}
		if(description.length()<5){
			log.info("La descripcion ingresada es muy corta");
			throw new TooShortException("La descripcion ingresada es muy corta");
		}
	}

	private static void validateStock(Integer stock) throws NullException, MinException {
		if(stock == null){
			log.info("El stock no puede estar vacío");
			throw new NullException("El stock no puede estar vacío");
		}
		if(stock < 0){
			log.info("El stock no puede ser un número negativo");
			throw new MinException("El stock no puede ser un número negativo");
		}
	}

	private static void validatePrice(Double price) throws NullException, MinException{
		if(price == null){
			log.info("El precio no puede estar vacío");
			throw new NullException("El precio no puede estar vacío");
		}
		if(price < 0){
			log.info("El precio no puede ser un número negativo");
			throw new MinException("El precio no puede ser un número negativo");
		}
	}
}

package com.deg.facturacionjpah2.validator;

import com.deg.facturacionjpah2.exception.WrongCodeException;
import com.deg.facturacionjpah2.model.ClientsModel;
import com.deg.facturacionjpah2.exception.NullException;
import com.deg.facturacionjpah2.exception.TooShortException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ClientValidator {
	public static void clientValidator(ClientsModel newClient) throws Exception {
		validateName(newClient);
		validateLastname(newClient);
		validateDocNumber(newClient);
	}
	private static void validateName(ClientsModel newClient) throws Exception {
		if(newClient.getName().isEmpty()){
			log.info("El nombre no puede estar vacío");
			throw new NullException("El nombre no puede estar vacío");
		}

		else if(!newClient.getName().matches("^[a-zA-Z]+$")){
			log.info("El nombre del cliente solo puede tener letras mayúsculas o minusculas");
			throw new WrongCodeException("El nombre del cliente solo puede tener letras mayúsculas o minusculas");
		}

		else if(newClient.getName().length()<3){
			log.info("El nombre ingresado es muy corto");
			throw new TooShortException("El nombre ingresado es muy corto");
		}
	}

	private static void validateLastname(ClientsModel newClient) throws Exception {
		if(newClient.getLastname().isEmpty()){
			log.info("El apellido no puede estar vacío");
			throw new NullException("El apellido no puede estar vacío");
		}
		else if(!newClient.getLastname().matches("^[a-zA-Z]+$")){
			log.info("El apellido del cliente solo puede tener letras mayúsculas o minusculas");
			throw new WrongCodeException("El apellido del cliente solo puede tener letras mayúsculas o minusculas");
		}
		else if(newClient.getLastname().length()<5){
			log.info("El apellido ingresado es muy corto");
			throw new TooShortException("El apellido ingresado es muy corto");
		}
	}

	private static void validateDocNumber(ClientsModel newClient) throws Exception {
		if(newClient.getDocNumber().isEmpty()){
			log.info("El número de documento no puede estar vacío");
			throw new NullException("El número de documento no puede estar vacío");
		}
		else if(!newClient.getDocNumber().matches("^[0-9]+$")){
			throw new WrongCodeException("El número de documento solo puede tener numeros");
		}
		else if(newClient.getDocNumber().length()<6){
			log.info("El número de documento ingresado es muy corto");
			throw new TooShortException("El número de documento ingresado es muy corto");
		}
	}
}
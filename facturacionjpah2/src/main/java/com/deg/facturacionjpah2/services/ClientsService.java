package com.deg.facturacionjpah2.services;

import com.deg.facturacionjpah2.model.ClientsModel;
import com.deg.facturacionjpah2.exception.AlreadyExistsException;
import com.deg.facturacionjpah2.exception.NotFoundException;
import com.deg.facturacionjpah2.exception.IdNotValidException;
import com.deg.facturacionjpah2.repository.ClientRepository;
import com.deg.facturacionjpah2.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientsService {

	@Autowired
	private ClientRepository clientRepository;


	//Método para crear clientes.
	public ClientsModel create(ClientsModel newClient) throws Exception {
		ClientValidator.clientValidator(newClient);
		Optional<ClientsModel> clientOp = this.clientRepository.findByDocNumber(newClient.getDocNumber());

		if (clientOp.isPresent()){
			log.info("El cliente que intenta agregar ya existe en la base de datos: " + newClient);
			throw new AlreadyExistsException("El cliente que intenta agregar ya existe en la base de datos.");
		}else {

			return this.clientRepository.save(newClient);
		}
	}
	//Método para actualizar clientes.
	public ClientsModel update(ClientsModel newClient, Long id) throws Exception {
		log.info("ID INGRESADO: " + id);
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<ClientsModel> clientOp = this.clientRepository.findById(id);

		if (clientOp.isEmpty()){
			log.info("El cliente que intenta modificar no existe en la base de datos: " + newClient);
			throw new NotFoundException("El cliente que intenta modificar no existe en la base de datos.");
		}else {
			ClientValidator.clientValidator(newClient);

			log.info("El cliente fue encontrado.");
			ClientsModel clientBd = clientOp.get();
			clientBd.setName(newClient.getName());
			clientBd.setLastname(newClient.getLastname());
			clientBd.setDocNumber(newClient.getDocNumber());

			log.info("Cliente actualizado : " + clientBd);

			return this.clientRepository.save(clientBd);
		}
	}

	// Método para buscar un cliente por el ID.
	public ClientsModel findById(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<ClientsModel> clientOp = this.clientRepository.findById(id);

		if (clientOp.isEmpty()){
			log.info("El cliente con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El cliente que intenta solicitar no existe.");
		}else {
			return clientOp.get();
		}
	}

	// Método para buscar un cliente por numero de dni.

	public ClientsModel findByDocNumber(String docNumber) throws Exception {

		Optional<ClientsModel> clientOp = this.clientRepository.findByDocNumber(docNumber);

		if (clientOp.isEmpty()){
			log.info("El cliente con el documento brindado no existe en la base de datos: " + docNumber);
			throw new NotFoundException("El cliente que intenta solicitar no existe.");
		}else {
			return clientOp.get();
		}
	}

	//Método para buscar todos los clientes.
	public List<ClientsModel> findAll(){
		return this.clientRepository.findAll();
	}

	public void delete(Long id) throws Exception {
		if (id <= 0){
			throw new IdNotValidException("El id brindado no es valido.");
		}

		Optional<ClientsModel> clientOp = this.clientRepository.findById(id);

		if (clientOp.isEmpty()){
			log.info("El cliente con el id brindado no existe en la base de datos: " + id);
			throw new NotFoundException("El cliente que intenta solicitar no existe.");
		}else {
			log.info("El Id Ingresado: " + id + " ha sido eliminado.");
			clientOp.get().setStatus(false);
			clientRepository.save(clientOp.get());

		}
	}
}

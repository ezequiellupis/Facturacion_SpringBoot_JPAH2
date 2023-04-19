package com.deg.facturacionjpah2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Controlador de Excepciones
public class GlobalHandlerException {
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotValidException.class)
	public ResponseEntity<?> idNotValidException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(MinException.class)
	public ResponseEntity<?> minException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NullException.class)
	public ResponseEntity<?> nullException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TooShortException.class)
	public ResponseEntity<?> tooShortException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(WrongCodeException.class)
	public ResponseEntity<?> wrongCodeException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InsufficientStockException.class)
	public ResponseEntity<?> insufficientStockException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

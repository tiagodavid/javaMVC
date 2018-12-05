package br.com.unipe.projeto.projetoMVC.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author tiago
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceBadRequestException extends RuntimeException{
	public ResourceBadRequestException(String message) {
		super(message);
	}
}

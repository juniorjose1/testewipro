package br.com.alexandre.resource.exception;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.alexandre.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> ObjectNotFound(ObjectNotFoundException e,
			HttpServletRequest request){
		
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),
				e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler({AuthenticationException.class})
	public ResponseEntity<Object> AuthenticationException(InsufficientAuthenticationException ex, HttpServletRequest request){
		String mensagemUsuario = "Usuário e/ou Senha inválidos";
		String mensagemDesenvolvedor = Optional.ofNullable(ex.getCause()).orElse(ex).toString();
		
		List<ErrorAuthentication> erros = Arrays.asList(new ErrorAuthentication(mensagemUsuario, mensagemDesenvolvedor));
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erros);
	}
	
}

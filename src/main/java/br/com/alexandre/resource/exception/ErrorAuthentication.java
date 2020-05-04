package br.com.alexandre.resource.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorAuthentication implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String mensagemUsuario;
	private String mensagemDesenvolvedor;

}

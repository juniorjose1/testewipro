package br.com.alexandre.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.domain.Usuario;
import br.com.alexandre.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios(){
		List<Usuario> listaUsuarios = service.listarUsuarios();
		
		return ResponseEntity.status(HttpStatus.OK).body(listaUsuarios);
	}
	
}

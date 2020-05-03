package br.com.alexandre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexandre.domain.Usuario;
import br.com.alexandre.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> listaUsuarios = repo.findAll();
		
		return listaUsuarios;
	}

}

package br.com.alexandre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alexandre.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT login FROM Usuario")
	public String procurarPorLogin();
	
	@Query("SELECT senha FROM Usuario")
	public String procurarPorSenha();

}

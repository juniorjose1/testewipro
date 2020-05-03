package br.com.alexandre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alexandre.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("FROM Produto WHERE status = true")
	public List<Produto> listarProdutosAtivos();
	
	@Query("FROM Produto WHERE status = false")
	public List<Produto> listarProdutosInativos();

}

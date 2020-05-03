package br.com.alexandre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexandre.domain.Produto;
import br.com.alexandre.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto cadastrarProduto(Produto produto) {
		Produto produtoSalvo = repo.save(produto);
		
		return produtoSalvo;
	}

}

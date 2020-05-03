package br.com.alexandre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
	
	public List<Produto> listaProdutosAtivos(){
		List<Produto> produtosAtivos = repo.listarProdutosAtivos();
		
		return produtosAtivos;
	}
	
	public List<Produto> listaProdutosInativos(){
		List<Produto> produtosInativos = repo.listarProdutosInativos();
		
		return produtosInativos;
	}
	
	public Produto alterarProduto(Long codigo, Produto produtoAlterado) {
		Optional<Produto> produtoAntigo = repo.findById(codigo);
		BeanUtils.copyProperties(produtoAntigo, produtoAlterado);
		Produto produtoAlteradoSalvo = repo.save(produtoAlterado);
		
		return produtoAlteradoSalvo;
	}
	
	public Optional<Produto> buscarPorCodigo(Long codigo) {
		Optional<Produto> produtoSelecionado = repo.findById(codigo);
		
		return produtoSelecionado;
	}

}

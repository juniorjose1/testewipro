package br.com.alexandre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alexandre.domain.Produto;
import br.com.alexandre.repository.ProdutoRepository;
import br.com.alexandre.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto cadastrarProduto(Produto produto) {
		Produto produtoSalvo = repo.save(produto);
		
		return produtoSalvo;
	}
	
	public List<Produto> listaProdutosAtivos(Pageable pageable){
		Boolean status = true;
		Optional<List<Produto>> produtosAtivos = repo.findByStatus(status, pageable);
		
		return produtosAtivos.orElseThrow(() -> new ObjectNotFoundException(
				"Nenhum produto ativo encontrado !"));
	}
	
	public List<Produto> listaProdutosInativos(Pageable pageable){
		Boolean status = false;
		Optional<List<Produto>> produtosInativos = repo.findByStatus(status, pageable);
		
		return produtosInativos.orElseThrow(() -> new ObjectNotFoundException(
				"Nenhum produto inativo encontrado !"));
	}
	
	public Produto alterarProduto(Long codigo, Produto produtoAlterado) {
		Optional<Produto> produtoAntigo = repo.findById(codigo);
		if(produtoAntigo.isEmpty()) {
			return produtoAntigo.orElseThrow(() -> new ObjectNotFoundException(
					"Nenhum produto encontrado com o código: " + codigo));
		}else {
			BeanUtils.copyProperties(produtoAntigo, produtoAlterado);
			Produto produtoAlteradoSalvo = repo.save(produtoAlterado);
			return produtoAlteradoSalvo;
		}
	}
	
	public Produto buscarPorCodigo(Long codigo) {
		Optional<Produto> produtoSelecionado = repo.findById(codigo);
		
		return produtoSelecionado.orElseThrow(() -> new ObjectNotFoundException(
				"Nenhum produto encontrado com o código: " + codigo));
	}
	
	public Produto inativarProduto(Long codigo) {
		Optional<Produto> produtoSelecionado = repo.findById(codigo);
		
		if(produtoSelecionado.isEmpty()) {
			return produtoSelecionado.orElseThrow(() -> new ObjectNotFoundException(
					"Nenhum produto encontrado com o código: " + codigo));
		}else {
			
			Produto produtoInativado = new Produto();
			
			produtoInativado.setCodigo(produtoSelecionado.get().getCodigo());
			produtoInativado.setDescricao(produtoSelecionado.get().getDescricao());
			produtoInativado.setValorUnitario(produtoSelecionado.get().getValorUnitario());
			produtoInativado.setDataCriacao(produtoSelecionado.get().getDataCriacao());
			produtoInativado.setStatus(false);
			produtoInativado.setUsuario(produtoSelecionado.get().getUsuario());
			
			Produto produtoInativadoSalvo = repo.save(produtoInativado);
			
			return produtoInativadoSalvo;
		}
		
	}
	
	public Produto excluirProdutoPorCodigo(Long codigo) {
		Optional<Produto> produtoSelecionado = repo.findById(codigo);
		repo.deleteById(codigo);
		return produtoSelecionado.orElseThrow(() -> new ObjectNotFoundException(
				"Nenhum produto encontrado com o código: " + codigo));
	}

}

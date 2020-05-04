package br.com.alexandre.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.domain.Produto;
import br.com.alexandre.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@PostMapping("/cadastro")
	public ResponseEntity<Produto> cadastrarProduto(Produto produto){
		Produto produtoSalvo = service.cadastrarProduto(produto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
	}
	
	@GetMapping("/ativos")
	public ResponseEntity<List<Produto>> listarProdutosAtivos(Pageable pageable){
		List<Produto> produtosAtivos = service.listaProdutosAtivos(pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtosAtivos);
	}
	
	@GetMapping("/inativos")
	public ResponseEntity<List<Produto>> listarProdutosInativos(Pageable pageable){
		List<Produto> produtosInativos = service.listaProdutosInativos(pageable);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtosInativos);
	}
	
	@PutMapping("/edicao/{codigo}")
	public ResponseEntity<Produto> editarProduto(@PathVariable Long codigo, Produto produtoAlterado){
		Produto produtoAlteradoSalvo = service.alterarProduto(codigo, produtoAlterado);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoAlteradoSalvo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> listarProdutoPorCodigo(@PathVariable Long codigo){
		Produto produtoSelecionado = service.buscarPorCodigo(codigo);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoSelecionado);
	}
	
	@PutMapping("/inativacao/{codigo}")
	public ResponseEntity<Produto> inativarProduto(@PathVariable Long codigo){
		Produto produtoInativadoSalvo = service.inativarProduto(codigo);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoInativadoSalvo);
	}
	
	@DeleteMapping("/exclusao/{codigo}")
	public ResponseEntity<Produto> excluirProdutoPorCodigo(@PathVariable Long codigo) {
		Produto produtoSelecionado = service.excluirProdutoPorCodigo(codigo);
		
		return ResponseEntity.status(HttpStatus.OK).body(produtoSelecionado);
	}
}

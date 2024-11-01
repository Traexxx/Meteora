package br.com.meteora.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meteora.api.model.produto.DadosAtualizarProdutos;
import br.com.meteora.api.model.produto.DadosCadastrosProdutos;
import br.com.meteora.api.model.produto.ProdutoModel;
import br.com.meteora.api.model.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/produtos")

public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    // MÉTODOS HTTP
    @GetMapping("/listar")
    // CRIAÇÃO DE MÉTODO < - 'acesso' - 'tipos de saida' - NomedoMetodo
    public List<ProdutoModel> listar(){
        return repository.findAll();
    }

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrosProdutos dados){
        repository.save(new ProdutoModel(dados));
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody DadosAtualizarProdutos dados){
        ProdutoModel produto = repository.getReferenceById(dados.id());
        produto.atualizarProduto(dados);
        
    }

    @DeleteMapping("/{id}")
    @Transactional
    // DESSA FORMA NÃO SE MANTÉM NO BANCO DE DADOS
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}

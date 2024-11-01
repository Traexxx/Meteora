package br.com.meteora.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.meteora.api.model.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    // métodos HTTP

    // GET - mostrando informações
    @GetMapping("/listar")
    
    // MÉTODO JAVA listar
    public List<UsuarioModel> listar() {
        return repository.findAll();
    }

    // POST - ingetando informações
    @PostMapping("/cadastrar")
    // TODAS AS ALTERAÇÕES NO BANCO DE DADOS NECESSITA DA NOTATTION 'Transactional'
    @Transactional
    // MÉTODO JAVA cadastrar
    // chama a classe e cria uma referencia pra ela
    public void cadastrar(@RequestBody @Valid DadosCadastrosUsuario dados) {
        repository.save(new UsuarioModel(dados));
    }

    
    // PUT - atualizando informações
    @PutMapping
    // TODAS AS ALTERAÇÕES NO BANCO DE DADOS NECESSITA DA NOTATTION 'Transactional'
    @Transactional

    public void atualizar(@RequestBody DadosAtualizarUsuarios dados){
        // PUXANDO COMO REFERENCIA À USUARIO O ID 
        UsuarioModel usuario = repository.getReferenceById(dados.id());
        // Aqui irá utilizar o metodo criado para atualizar
        usuario.atualizarInformacoes(dados);
    }


    @DeleteMapping("/{id}")
    // TODAS AS ALTERAÇÕES NO BANCO DE DADOS NECESSITA DA NOTATTION 'Transactional'
    @Transactional
    // DESSA FORMA NÃO SE MANTÉM NO BANCO DE DADOS
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}

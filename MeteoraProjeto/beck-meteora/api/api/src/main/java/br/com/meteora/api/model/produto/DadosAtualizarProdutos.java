package br.com.meteora.api.model.produto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProdutos(
    @NotNull Long id,
    String nome,
    String tamanho,
    String descricao,
    Double preco,
    String modelo,
    String cor
    // String fabricante

) {
    
}
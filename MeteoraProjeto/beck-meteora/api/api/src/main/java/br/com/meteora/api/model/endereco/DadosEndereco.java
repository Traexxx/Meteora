package br.com.meteora.api.model.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
    @NotBlank String logradouro,
    @NotBlank String bairro,
    @NotBlank String cep,
    @NotBlank String numero,
    @NotBlank String complemento,
    @NotBlank String cidade,
    @NotBlank String uf
){

}


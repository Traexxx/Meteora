package br.com.meteora.api.model.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.*;
@Embeddable

@Getter
@Table(name = "endereco")
@NoArgsConstructor
@AllArgsConstructor



public class EnderecoModel {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;



    // RELACIONADO AO GET (ATUALIZAR)
    // ESTE METODO VERIFICA QUAL DADO ESTA SENDO ALTERADO.
    // ele acessa os DadosEndereço, verifica o que está sendo alterado
    public void atualizarEndereco(DadosEndereco dados){
        if (dados.logradouro()!= null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro()!= null) {
            this.bairro = dados.bairro();
        }
        if (dados.cep()!= null) {
            this.cep = dados.cep();
        }
        if (dados.numero()!= null) {
            this.numero = dados.numero();  
        }
        if (dados.complemento()!= null) {
            this.complemento = dados.complemento();
        }
        if (dados.cidade()!= null) {
            this.cidade = dados.cidade();
        }
        if (dados.uf()!= null){
            this.uf = dados.uf();
        }

    }

    public EnderecoModel(DadosEndereco dados){
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
}

    
}

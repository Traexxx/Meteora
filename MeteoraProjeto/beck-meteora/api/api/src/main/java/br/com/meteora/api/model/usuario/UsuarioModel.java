package br.com.meteora.api.model.usuario;

import br.com.meteora.api.model.endereco.EnderecoModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")

public class UsuarioModel {
    // GERAÇÃO DE ID AUTONOMA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String dataDeNascimento;
    private String cpf;
    private char genero;
    @Embedded
    private EnderecoModel endereco;
    private String email;
    private String senha;
    
    // RELACIONADO AO MÉTODO DO PUT
    // ESTE METODO VERIFICA QUAL DADOS ESTA SENDO ALTERADO.
    public void atualizarInformacoes(DadosAtualizarUsuarios dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.dataDeNascimento() != null) {
            this.dataDeNascimento = dados.dataDeNascimento();
        }
        // aqui ele ira utilizar o método criado no model O.o
        if (dados.endereco() != null) {
            this.endereco.atualizarEndereco(dados.endereco());  
        }
    }

    // CONSTRUCTOR
    public UsuarioModel(DadosCadastrosUsuario dados){
        this.nome = dados.nome();
        this.dataDeNascimento = dados.dataDeNascimento();
        this.cpf = dados.cpf();
        this.genero = dados.genero();
        // Puxando o método e o preenchendo
        this.endereco = new EnderecoModel(dados.endereco());
        this.email = dados.email();
        this.senha = dados.senha();

    }
}

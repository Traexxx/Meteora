package br.com.meteora.api.model.produto;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Produto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class ProdutoModel {
    // Geração do ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Variáveis
    private String nome;
    private String tamanho;
    private String modelo;
    private String descricao;
    private double preco;
    private String cor;
    // ?
    @Enumerated(EnumType.STRING)
    private Fabricante fabricante;

    public void atualizarProduto(DadosAtualizarProdutos dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.tamanho() != null) {
            this.tamanho = dados.tamanho();
        }
        if (dados.modelo() != null) {
            this.modelo = dados.modelo();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if (dados.preco() != null) {
            this.preco = dados.preco();
        }
        if (dados.cor() != null) {
            this.cor = dados.tamanho();
        }

        // if (dados.fabricante() != null) {
        //     this.fabricante = dados.fabricante();
            
        // }
    }

    // Constructor
    public ProdutoModel(DadosCadastrosProdutos dados) {
        this.nome = dados.nome();
        this.tamanho = dados.tamanho();
        this.modelo = dados.modelo();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.cor = dados.cor();
        // ?
        this.fabricante = dados.fabricante();
    }
}

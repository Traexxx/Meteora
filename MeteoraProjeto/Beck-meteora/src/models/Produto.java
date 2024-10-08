package models;

public class Produto {
    private int id;
    private String nome;
    private String tamanho;
    private String modelo;
    private String descricao;
    private double preco;
    private String cor;
    private String fabricante;
    
    
    public Produto(String nome, String tamanho, String modelo, String descricao, double preco, String cor,
            String fabricante) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.descricao = descricao;
        this.preco = preco;
        this.cor = cor;
        this.fabricante = fabricante;
    }




    public int getId(){
        return id;
    } 

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTamanho() {
        return tamanho;
    }


    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }


    public String getModelo() {
        return modelo;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public double getPreco() {
        return preco;
    }


    public void setPreco(double preco) {
        this.preco = preco;
    }


    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
    }


    public String getFabricante() {
        return fabricante;
    }


    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    

}

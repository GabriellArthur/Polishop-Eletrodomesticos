package br.com.gabriellarthur.eletrodomesticos.main;

public abstract class Produtos {
    private String nome;
    private String descricao;
    private int preco;
    private float avaliacao;
    private float peso;
    //Construtor
    public Produtos(String nome, String descricao, int preco, float avaliacao, float peso) {
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setAvaliacao(avaliacao);
        setPeso(peso);
    }
    //Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
    //Relatorio
    @Override
    public String toString() {
        return "Nome:" + getNome() 
        +"\nDescricao:" + getDescricao() 
        +"\nAvaliacao:" + getAvaliacao() 
        +"\nPreco:" + getPreco() 
        +"R$\nPeso:" + getPeso() + "kg\n";
    }

}

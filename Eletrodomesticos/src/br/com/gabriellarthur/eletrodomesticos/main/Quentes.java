package br.com.gabriellarthur.eletrodomesticos.main;

public abstract class Quentes extends Produtos {
    private boolean eletrico;
    //Construtor
    public Quentes(String nome, String descricao, int preco, float avaliacao, float peso,boolean eletrico) {
        super(nome, descricao, preco, avaliacao, peso);
        setEletrico(eletrico); //Se o forno eh eletrico ou nao
    }
    //Getters and Setters
    public boolean isEletrico() {
        return eletrico;
    }

    public void setEletrico(boolean eletrico) {
        this.eletrico = eletrico;
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

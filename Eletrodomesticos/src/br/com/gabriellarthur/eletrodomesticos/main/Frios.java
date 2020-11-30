package br.com.gabriellarthur.eletrodomesticos.main;

public abstract class Frios extends Produtos {
    private int portas;
    //Construtor
    public Frios(String nome, String descricao, int preco, float avaliacao, float peso, int portas) {
        super(nome, descricao, preco, avaliacao, peso);
        setPortas(portas);
    }
    //Getters and Setters
    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }
    //Relatorio
    @Override
    public String toString() {
        return "Nome:" + getNome() 
	    	+"\nDescricao:" + getDescricao() 
	    	+"\nAvaliacao:" + getAvaliacao() 
	    	+"\nPreco:" + getPreco() 
	    	+"R$\nPeso:" + getPeso() 
	    	+ "kg\nPortas:"+ getPortas();
    }
}

package br.com.gabriellarthur.eletrodomesticos.main;

public class Depurador extends Coifas {
	//Construtor
    public Depurador(String nome, String descricao , int preco, float avaliacao, float peso) {
        super(nome, descricao, preco, avaliacao, peso);
    }
    //Interface
    @Override
    public String incrementarMarcaEletrolux() {
        return "ELETROLUX";
    }
    //Relatorio
    @Override
    public String toString() {
        return "Nome:" + getNome() 
	        + "|" + incrementarMarcaEletrolux() 
	        + "\nDescricao:" + getDescricao()
	        + "\nAvaliacao:" + getAvaliacao() 
	        + "\nPreco:" + getPreco() 
	        +"R$\nPeso:" + getPeso() + "kg"
	        +"\nGarantia"+garantia();
    }

}

package br.com.gabriellarthur.eletrodomesticos.main;

import br.com.gabriellarthur.eletrodomesticos.interfaces.Eletrolux;

public class Bebedouro extends Produtos implements Eletrolux {
    //Construtor
    public Bebedouro(String nome, String descricao, int preco, float avaliacao, float peso) {
        super(nome, descricao, preco, avaliacao, peso);
    }
    //Interface
    @Override
    public String incrementarMarcaEletrolux() {
        return "ELETROLUX";
    }
    
	@Override
	public String garantia() {
		return "2 anos";
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

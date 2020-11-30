package br.com.gabriellarthur.eletrodomesticos.main;

import br.com.gabriellarthur.eletrodomesticos.interfaces.Eletrolux;

public class Geladeira extends Frios implements Eletrolux {
	//Construtor
    public Geladeira(String nome, String descricao, int preco, float avaliacao, float peso,
            int portas) {
        super(nome, descricao, preco, avaliacao, peso, portas);
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
	
    @Override
    public String toString() {
        return "Nome:" + getNome() 
	    	+"\nDescricao:" + getDescricao() 
	    	+"\nAvaliacao:" + getAvaliacao() 
	    	+"\nPreco:" + getPreco() 
	    	+"R$\nPeso:" + getPeso() 
	    	+ "kg\nPortas:"+ getPortas()
	    	+"\nGarantia"+garantia();
    }
}

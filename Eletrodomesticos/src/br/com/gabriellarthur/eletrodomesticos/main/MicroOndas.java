package br.com.gabriellarthur.eletrodomesticos.main;

import br.com.gabriellarthur.eletrodomesticos.interfaces.Eletrolux;

public class MicroOndas extends Quentes implements Eletrolux {
	//Construtor
    public MicroOndas(String nome, String descricao, int preco, float avaliacao, float peso, boolean eletrico) {
        super(nome, descricao, preco, avaliacao, peso, eletrico);
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
            + "R$\nPeso:" + getPeso() 
            + "kg\nGarantia:" + garantia();
    }
}

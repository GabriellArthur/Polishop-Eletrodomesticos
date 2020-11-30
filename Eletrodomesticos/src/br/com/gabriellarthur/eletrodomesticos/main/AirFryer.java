package br.com.gabriellarthur.eletrodomesticos.main;

import br.com.gabriellarthur.eletrodomesticos.interfaces.Philips;
import br.com.gabriellarthur.eletrodomesticos.interfaces.Cuisinart;
import br.com.gabriellarthur.eletrodomesticos.interfaces.Oster;
import br.com.gabriellarthur.eletrodomesticos.interfaces.Polishop;

public class AirFryer extends Quentes implements Philips, Polishop, Oster, Cuisinart {
    String marca;
	//Construtor
    public AirFryer(String nome, String descricao, int preco, float avaliacao, float peso,
            boolean eletrico,String marca) {
        super(nome, descricao, preco, avaliacao, peso, eletrico);
        selecionarMarca(marca);
    }
    //Funcoes
    public void selecionarMarca(String marca) {
	    switch (marca) {
	        case "Philips":
	            this.marca = incrementarMarcaPhilips();
	            break;
	        case "Polishop":
	            this.marca = incrementarMarcaPolishop();
	            break;
	        case "Oster":
	            this.marca = incrementarMarcaOster();
	            break;
	        case "Cuisinart":
	            this.marca = incrementarMarcaCuisinart();
	            break;
	    }
    }
    //Interface
    @Override
    public String incrementarMarcaPhilips() {
        return "PHILIPS";
    }

    @Override
    public String incrementarMarcaPolishop() {
        return "POLISHOP";
    }

    @Override
    public String incrementarMarcaOster() {
        return "OSTER";
    }

    @Override
    public String incrementarMarcaCuisinart() {
        return "CUISINART";
    }
    
	@Override
	public String garantia() {
		return "2 anos";
	}
    //Relatorio
    @Override
    public String toString() {
        return "Nome:" + getNome() 
			+ "|" + this.marca 
			+ "\nDescricao:" + getDescricao() 
            + "\nAvaliacao:" + getAvaliacao() 
            + "\nPreco:" + getPreco() 
            +"R$\nPeso:" + getPeso() + "kg"
            +"\nGarantia"+garantia();
    }

}

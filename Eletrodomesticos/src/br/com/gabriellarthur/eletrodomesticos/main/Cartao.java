package br.com.gabriellarthur.eletrodomesticos.main;

public class Cartao {
    protected String bandeira;
    protected String tipo;
    protected int numero;
    protected int cvv;
    protected int validade;
    protected int saldo;

    // Construtor
    public Cartao(String bandeira, String tipo, int numero, int cvv, int validade, int saldo) {
        setBandeira(bandeira);
        setTipo(tipo);
        setNumero(numero);
        setCvv(cvv);
        setValidade(validade);
        setSaldo(saldo);
    }

    // Funcoes
    public void adicionarSaldo(int valor) {
        setSaldo(getSaldo() + valor);
    }

    public void retirarSaldo(int valor) {
        setSaldo(getSaldo() - valor);
    }

    public void transferirSaldo(int valor, Cartao cartaoDestino) {
        cartaoDestino.adicionarSaldo(valor);
        retirarSaldo(valor);
    }

    // Getters and Setters
    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // Relatorio
    @Override
    public String toString() {
        return "Cartao de " + getTipo() 
	        + "\nBandeira:" + getBandeira() 
	        + "\nNumero: " + getNumero() 
	        + "\nCVV:"+ getCvv() 
            + "\nValidade:" + getValidade() 
            + "\n\nSaldo:" + getSaldo() + "\n";
    }
}

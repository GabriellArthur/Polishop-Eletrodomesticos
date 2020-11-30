package br.com.gabriellarthur.eletrodomesticos.main;

import java.util.ArrayList;

import br.com.gabriellarthur.eletrodomesticos.utils.Utils;
import br.com.gabriellarthur.eletrodomesticos.utils.View;

public class Usuario {
    private String nome;
    private String telefone;
    private ArrayList<String> enderecos; //Usuario pode cadastrar varios enderecos
    private ArrayList<Cartao> cartoes; //Usuario pode cadastrar varios cartoes
    private ArrayList<String> pedidos;	//LOG - Aonde fica registrado todas as compras
    private ArrayList<Produtos> favoritos; //Os seus eletrodomesticos favoritos
    private ArrayList<Produtos> presentes; //A sua lista de presentes

    // Contrutor
    public Usuario(String nome, String telefone) {
        setNome(nome);
        setTelefone(telefone);
        setEnderecos(new ArrayList<String>());
        setCartoes(new ArrayList<Cartao>());
        setPedidos(new ArrayList<String>());
        setFavoritos(new ArrayList<Produtos>());
        setPresentes(new ArrayList<Produtos>());
    }

    // Metodos
    public void trocarTelefone() {
        try {
            setTelefone(Utils.registrarTelefone());
            View.exibirMensagem("Telefone alterado com sucesso!");
        } catch (Exception e) {
            View.exibirError("ERROR", e.getMessage());
        }
    };

    public void addEndereco() {
        getEnderecos().add(View.inserirString("ENDERECO - ADD", "Informe o seu endereco:"));
    };

    public void removeEndereco() {
        getEnderecos().remove(View.inserirInt("ENDERECO - REMOVER", listarEndereco() + "Informe a numeracao que deseja deletar:"));
    };

    public String listarEndereco() {
        String auxEnderecos = "";
        int i = 0;
        for (String endereco : enderecos) {
            auxEnderecos += i + " - " + endereco + "\n";
            i++;
        }
        View.exibirMensagem("" + auxEnderecos);
        return auxEnderecos;
    }

    public void addCartao() { 
        getCartoes().add(Utils.registrarCartao());
    };

    public void addCartao(Cartao c) {
        getCartoes().add(c);
    }

    public void removeCartao() {
        String auxCartao = "";
        int i = 0;
        for (Cartao cartao : cartoes) {
            auxCartao += i + " - " + cartao + "\n";
            i++;
        }
        getCartoes().remove(View.inserirInt("CARTAO - DELET", auxCartao + "\n\nInfome o numero"));
    };

    public void listarCartao() {
        View.exibirMensagem(getCartoes().toString());
    }

    public void informarPedidosRealizados() { //LOG
        String auxPedidos = "";
        int i = 0;
        for (String pedido : pedidos) {
            auxPedidos += i + " - " + pedido + "\n";
            i++;
        }
        View.exibirMensagem("" + auxPedidos);
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ArrayList<String> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<String> enderecos) {
        this.enderecos = enderecos;
    }

    public ArrayList<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(ArrayList<Cartao> cartoes) {
        this.cartoes = cartoes;
    }

    public ArrayList<String> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<String> pedidos) {
        this.pedidos = pedidos;
    }
    
    public ArrayList<Produtos> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(ArrayList<Produtos> favoritos) {
		this.favoritos = favoritos;
	}

	public ArrayList<Produtos> getPresentes() {
		return presentes;
	}

	public void setPresentes(ArrayList<Produtos> presentes) {
		this.presentes = presentes;
	}

	//Relatorio
    @Override
    public String toString() {
        return "Usuario:" + getNome() 
        		+ "\nTelefone:" + getTelefone() 
        		+ "\nEnderecos:" + getEnderecos().size()
                + "\nCartoes:" + getCartoes().size() 
                + "\nPedidos:" + getPedidos().size()
                +"\nFavoritos:"+getFavoritos().size()
                +"\nPresentes:"+getPresentes().size();
    }
}

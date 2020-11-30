package br.com.gabriellarthur.eletrodomesticos.utils;

import java.util.Random;

import br.com.gabriellarthur.eletrodomesticos.main.Cartao;
import br.com.gabriellarthur.eletrodomesticos.main.Usuario;

public class Utils {
	// -----------------TESTES-----------///
	public static Usuario usuarioTest() {
		Usuario u = new Usuario("Gabriel Arthur", "(61)991877872");
		return u;
	}

	public static Cartao cartaoTest() {
		Cartao c = new Cartao("MasterCard", "Debito", 123, 123, 123, 2000);
		return c;
	}
	// -------------------------------------------------------//

	public static Usuario registrarUsuario() {
		String nome = View.inserirString("REGISTRO", "Informe o seu nome:");
		String telefone = registrarTelefone();
		Usuario u = new Usuario(nome, telefone);
		return u;
	}

	public static String registrarTelefone() {
		int numero = 0;
		int ddd = 0;
		String telefone = "";
		do {
			ddd = View.inserirInt("TELEFONE", "(DDD)9-NUMERO\nInforme o DDD:");
			if (ddd <= 10 && ddd >= 100)
				View.exibirError("TELEFONE", "DDD invalido");
		} while (ddd <= 10 && ddd >= 100);
		do {
			numero = View.inserirInt("TELEFONE", "(DDD)9-NUMERO\nInforme o numero:");
			if (numero <= 10000000 && numero >= 100000000)
				View.exibirError("TELEFONE", "Numero invalido");
		} while (numero <= 10000000 && numero >= 100000000);
		telefone = "(" + ddd + ")" + 9 + numero;
		return telefone;
	}

	public static Cartao registrarCartao() {
		String bandeira = View.menu("MasterCard", "Visa", "Elo", "HiperCard", "CARTAO", "Bandeira");
		String tipo = View.menu("Debito", "Credito", "CARTAO", "Tipo");
		int numero = View.inserirInt("CARTAO", "Numeracao:");
		int cvv = View.inserirInt("CARTAO", "CVV:");
		int validade = View.inserirInt("CARTAO", "Validade:");
		int saldo = View.inserirInt("CARTAO", "Saldo:");
		Cartao c = new Cartao(bandeira, tipo, numero, cvv, validade, saldo);
		return c;
	}

	// -------------------------------------------------------//
	public static int randomInRangeInt(int menor, int maior) {
		Random r = new Random();
		int result = r.nextInt(maior - menor) + menor;
		return result;
	}
}

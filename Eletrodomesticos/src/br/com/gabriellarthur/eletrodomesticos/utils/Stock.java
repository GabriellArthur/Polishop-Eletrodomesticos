package br.com.gabriellarthur.eletrodomesticos.utils;

import br.com.gabriellarthur.eletrodomesticos.main.Adegas;
import br.com.gabriellarthur.eletrodomesticos.main.AirFryer;
import br.com.gabriellarthur.eletrodomesticos.main.Bebedouro;
import br.com.gabriellarthur.eletrodomesticos.main.Cervejeiras;
import br.com.gabriellarthur.eletrodomesticos.main.Coifas;
import br.com.gabriellarthur.eletrodomesticos.main.Depurador;
import br.com.gabriellarthur.eletrodomesticos.main.Forno;
import br.com.gabriellarthur.eletrodomesticos.main.Freezer;
import br.com.gabriellarthur.eletrodomesticos.main.Geladeira;
import br.com.gabriellarthur.eletrodomesticos.main.MicroOndas;

public class Stock {
    // --------------FRIOS----------//
    public static Geladeira gerarGeladeira() {
        String nome = "Geladeira French Door";
        String descricao = "Este produto eh totalmente versatil. Tudo para ser personalizado para comportar o que o voce preferir.";
        int preco = 6000;
        float avaliacao = 4;
        float peso = 113;
        int portas = 3;
        Geladeira g = new Geladeira(nome, descricao, preco, avaliacao, peso, portas);
        return g;
    }

    public static Freezer gerarFreezer() {
        String nome = "Freezer";
        String descricao = "Mais rapidez e melhor conservacao para os seus alimentos. Design pratico e moderno para voce.";
        int preco = 1149;
        float avaliacao = 3;
        float peso = 30;
        int portas = 1;
        Freezer f = new Freezer(nome, descricao, preco, avaliacao, peso, portas);
        return f;
    }

    public static Adegas gerarAdegas() {
        String nome = "Adega 8 Garrafas";
        String descricao = "Permite controlar a temperatura sem ter que abrir a adega desnecessariamente.";
        int preco = 759;
        float avaliacao = 4;
        float peso = 9;
        int portas = 1;
        Adegas a = new Adegas(nome, descricao, preco, avaliacao, peso, portas);
        return a;
    }

    public static Cervejeiras gerarCervejeiras() {
        String nome = "Cervejeira 100L Painel White Touch";
        String descricao = "120 latas de cerveja de 350 ml, 91 garrafas de 355 ml, 37 garrafas de 600 ml, 28 garrafas de 1 litro e ate 5 barris de cerveja de 5 litros.";
        int preco = 4839;
        float avaliacao = 2;
        float peso = 28;
        int portas = 1;
        Cervejeiras c = new Cervejeiras(nome, descricao, preco, avaliacao, peso, portas);
        return c;
    }

    // --------------QUENTES----------//
    public static Forno gerarForno() {
        String nome = "Forno";
        String descricao = "Com 73L de capacidade, permite assar de forma mais homogenea, garantindo que suas receitas fiquem irresistiveis.";
        int preco = 3299;
        float avaliacao = 5;
        float peso = 28;
        boolean eletrico = false;
        // String marca = "Polishop";
        // String marca ="Oster";
        String marca = "Cuisinart";
        Forno f = new Forno(nome, descricao, preco, avaliacao, peso, eletrico, marca);
        return f;
    }

    public static MicroOndas gerarMicroOndas() {
        String nome = "Micro-Ondas Branco";
        String descricao = "27L com 55 Receitas pre-programadas no Menu Online";
        int preco = 639;
        float avaliacao = 5;
        float peso = 14;
        boolean eletrico = true;
        MicroOndas m = new MicroOndas(nome, descricao, preco, avaliacao, peso, eletrico);
        return m;
    }

    public static AirFryer gerarAirFryer() {
        String nome = "Fritadeira Eletrica Airfryer";
        String descricao = "Sem usar uma sa gota de oleo!";
        int preco = 1128;
        float avaliacao = 3;
        float peso = 5;
        boolean eletrico = true;
        String marca = "Polishop";
        // String marca ="Oster";
        // String marca ="Cuisinart";
        AirFryer a = new AirFryer(nome, descricao, preco, avaliacao, peso, eletrico, marca);
        return a;
    }

    // --------------COIFAS----------//
    public static Coifas gerarCoifas() {
        String nome = "Coifa de inox";
        String descricao = "Sua altura eh regulavel, garantindo facilidade na sua instalacao.";
        int preco = 999;
        float avaliacao = 2;
        float peso = 20;
        Coifas c = new Coifas(nome, descricao, preco, avaliacao, peso);
        return c;
    }

    public static Depurador gerarDepurador() {
        String nome = "Depurador 60cm de Parede";
        String descricao = "Possui uma Mascara Captadora de Ar que elimina a fumaca";
        int preco = 439;
        float avaliacao = 2;
        float peso = 20;
        Depurador d = new Depurador(nome, descricao, preco, avaliacao, peso);
        return d;
    }

    // --------------BEBEDOURO----------//
    public static Bebedouro gerarBebedouro() {
        String nome = "Bebedouro de agua";
        String descricao = "Com o Bebedouro de agua Eletronico voce vai se manter mais hidratado e refrescado o tempo inteiro.";
        int preco = 540;
        float avaliacao = 4;
        float peso = 11;
        Bebedouro b = new Bebedouro(nome, descricao, preco, avaliacao, peso);
        return b;
    }
}

/*
Nome: Gabriel Arthur Ferreira Fiusa
Matricula: UC19106718
*/
package br.com.gabriellarthur.eletrodomesticos.main;

import java.util.ArrayList;

import br.com.gabriellarthur.eletrodomesticos.utils.Stock;
import br.com.gabriellarthur.eletrodomesticos.utils.Utils;
import br.com.gabriellarthur.eletrodomesticos.utils.View;

public class Executora {
	public static void main(String[] args) {
		ArrayList<Produtos> produtos = new ArrayList<Produtos>();
		Usuario u = null;
		String opcoes = "";
		do {
			try {
				if(u != null && produtos.size()>=1){
					opcoes = View.menu("Usuario", "Produtos", "Carrinho", "Favoritos", "Presentes", "Menu", "opcoes");
				}else if (u == null){
					opcoes = View.menu("Criar Usuario", "Produtos", "Menu", "opcoes"); // Menu para qualquer pessoa
				}else {
					opcoes = View.menu("Usuario", "Produtos", "Menu", "opcoes"); // Menu para usuarios que nao conhecer os produtos
				}
			} catch (Exception e) {
				opcoes = "Sair";
			}
			switch (opcoes) {
				case "Criar Usuario":
					u = Utils.registrarUsuario();
					/*								//Facilitar a correcao e testes
					u = Utils.usuarioTest();
					u.addCartao(Utils.cartaoTest());
					u.addCartao(Utils.cartaoTest());
					*/
					break;
				case "Usuario":
					usuario(u);
					break;
				case "Produtos":
					produtos(produtos);
					break;
				case "Carrinho":
					carrinho(produtos, u, 1);
					break;
				case "Favoritos":
					carrinho(produtos, u, 2);
					break;
				case "Presentes":
					carrinho(produtos, u, 3);
					break;
			}
		} while (opcoes != "Sair");

	}

	public static void usuario(Usuario u) {
		String opcoes = "";
		do {
			try {
				opcoes = View.menu("Alterar o Telefone", "Endereco", "Cartao", "Compras", "USUARIO",
						u + "\n\nOperacoes:");
			} catch (Exception e) {
				opcoes = "Sair";
			}
			switch (opcoes) {
				case "Alterar o Telefone": //Alterar o telefone cadastrado
					u.trocarTelefone();
					break;
				case "Endereco":
					usuario_Endereco(u); //Menu de Enderecos
					break;
				case "Cartao":
					usuario_Cartao(u); //Menu de Cartoes
					break;
				case "Compras":
					if (u.getPedidos().isEmpty()) {
						View.exibirMensagem("Voce nao possui compras realizadas!");
					} else {
						u.informarPedidosRealizados();
					}
					break;
			}
		} while (opcoes != "Sair");
	}

	public static void usuario_Endereco(Usuario u) {
		String opcoes = "";
		do {
			try {
				opcoes = View.menu("Adicionar", "Remover", "Listar", "ENDERECO",
						"Enderecos:" + u.getEnderecos().size() + "\n\nOperacoes:");
			} catch (Exception e) {
				opcoes = "Sair";
			}
			switch (opcoes) { //O basico de enderecos
				case "Adicionar":
					u.addEndereco();
					break;
				case "Remover":
					u.removeEndereco();
					break;
				case "Listar":
					u.listarEndereco();
					break;
			}

		} while (opcoes != "Sair");
	}

	public static void usuario_Cartao(Usuario u) {
		String opcoes = "";
		do {
			try {
				opcoes = View.menu("Adicionar", "Remover", "Listar", "Depositar", "Retirar", "CARTAO",
						"Cartoes:" + u.getCartoes().size() + "\n\nOperacoes:");
			} catch (Exception e) {
				opcoes = "Sair";
			}
			switch (opcoes) { //O basico de cartoes
				case "Adicionar":
					u.addCartao();
					break;
				case "Remover":
					u.removeCartao();
					break;
				case "Listar":
					u.listarCartao();
					break;
				case "Depositar": //retirar ou depoistar
				case "Retirar":
					int x = 0;
					String auxCartao = "";
					int opCartao1 = 1;
					int opcoesCartao1 = 0;
					int valor = 0;
					try {
						valor = View.inserirInt("CARTEIRA", "Valor:"); //Valor para operacoes
						do {
							auxCartao = "";
							x = 0;
							for (Cartao cartao : u.getCartoes()) {
								x++;
								auxCartao += "[" + x + "]" + cartao.getTipo() + " - " + cartao.getSaldo() + "R$\n";
								if ((opcoesCartao1) == x) {
									if (opcoes == "Depositar") {
										cartao.adicionarSaldo(valor); // Depositar
										View.exibirMensagem(valor + " foi depositado!");
									}
									if (opcoes == "Retirar") {
										if (cartao.getSaldo() >= valor) { //Retirar | Sacar
											cartao.retirarSaldo(valor);
											View.exibirMensagem(valor + " foi retirado!");
										} 
									}
									opCartao1 = 0;
								}
								auxCartao += "\n";
							}
							if (opCartao1 == 1) {
								try {
									opcoesCartao1 = View.inserirInt("PAGAR", auxCartao + "\nEscolha o cartao:"); //Escolher o cartao
								} catch (Exception e) {
									opCartao1 = 0;
								}
							}
						} while (opCartao1 != 0);
					} catch (Exception e) {
						View.exibirError("ERROR", e.getMessage());
					}
					break;
			}

		} while (opcoes != "Sair");
	}

	public static void produtos(ArrayList<Produtos> produtos) {
		// ------------------------------------------------// Gera os produtos
		Geladeira geladeira = Stock.gerarGeladeira();
		Freezer freezer = Stock.gerarFreezer();
		Adegas adegas = Stock.gerarAdegas();
		Cervejeiras cervejeiras = Stock.gerarCervejeiras();

		Forno forno = Stock.gerarForno(); //
		MicroOndas microOndas = Stock.gerarMicroOndas();
		AirFryer airFryer = Stock.gerarAirFryer(); //

		Coifas coifas = Stock.gerarCoifas();
		Depurador depurador = Stock.gerarDepurador();

		Bebedouro bebedouro = Stock.gerarBebedouro();
		// ------------------------------------------------// Adiciona eles a loja
		produtos.add(geladeira);
		produtos.add(freezer);
		produtos.add(adegas);
		produtos.add(cervejeiras);
		produtos.add(forno);
		produtos.add(microOndas);
		produtos.add(airFryer);
		produtos.add(coifas);
		produtos.add(depurador);
		produtos.add(bebedouro);
		// ------------------------------------------------// Menu
		String opcoesMenu = "";
		do {
			try {
				opcoesMenu = View.menu("Marca", "Categorias", "PRODUTOS", "Filtrar:");
			} catch (Exception e) {
				opcoesMenu = "Sair";
			}
			switch (opcoesMenu) { //Listagem por marca
				case "Marca":
					String opcoesMarca = "";
					do {
						try {
							opcoesMarca = View.menu("Eletrolux", "Oster", "Cuisinart", "Philips", "Polishop", "MARCA","Filtrar:"); //Informa a marca
						} catch (Exception e) {
							opcoesMarca = "Sair";
						}
						switch (opcoesMarca) { //Mostra as marcas
							case "Eletrolux":
								String Eletrolux = "";
								Eletrolux += geladeira.getNome() + "\n";
								Eletrolux += freezer.getNome() + "\n";
								Eletrolux += adegas.getNome() + "\n";
								Eletrolux += cervejeiras.getNome() + "\n";
								Eletrolux += microOndas.getNome() + "\n";
								Eletrolux += coifas.getNome() + "\n";
								Eletrolux += depurador.getNome() + "\n";
								Eletrolux += bebedouro.getNome() + "\n";
								View.exibirMensagem(Eletrolux);
								break;
							case "Oster":
								String Oster = "";
								Oster += forno.getNome() + "\n";
								Oster += airFryer.getNome() + "\n";
								View.exibirMensagem(Oster);
								break;
							case "Cuisinart":
								String Cuisinart = "";
								Cuisinart += forno.getNome() + "\n";
								Cuisinart += airFryer.getNome() + "\n";
								View.exibirMensagem(Cuisinart);
								break;
							case "Philips":
								String Philips = "";
								Philips += airFryer.getNome() + "\n";
								View.exibirMensagem(Philips);
								break;
							case "Polishop":
								String Polishop = "";
								Polishop += forno.getNome() + "\n";
								Polishop += airFryer.getNome() + "\n";
								View.exibirMensagem(Polishop);
								break;
						}
					} while (opcoesMarca != "Sair");
					break;
				case "Categorias": //Listar por categoria
					String opcoesCategorias = "";
					do {
						try {
							opcoesCategorias = View.menu("Frios", "Quentes", "Coifas/Depurador", "Bebedouros",
									"CATEGORIAS", "Informe a categoria:"); //Categorias
						} catch (Exception e) {
							opcoesCategorias = "Sair";
						}
						switch (opcoesCategorias) {
							case "Frios":
								String opcoesFrios = "";
								do {
									try {
										opcoesFrios = View.menu("Geladeira", "Freezer", "Adegas", "Cervejeiras","FRIOS", "Informe o produto:");//Produtos de cada categoria
									} catch (Exception e) {
										opcoesFrios = "Sair";
									}
									switch (opcoesFrios) {
										case "Geladeira":
											View.exibirMensagem("" + geladeira);
											break;
										case "Freezer":
											View.exibirMensagem("" + freezer);
											break;
										case "Adegas":
											View.exibirMensagem("" + adegas);
											break;
										case "Cervejeiras":
											View.exibirMensagem("" + cervejeiras);
											break;
									}
								} while (opcoesFrios != "Sair");
								break;
							case "Quentes":
								String opcoesQuentes = "";
								do {
									try {
										opcoesQuentes = View.menu("Forno", "MicroOndas", "Airfryer", "QUENTES","Informe o produto:");//Produtos de cada categoria
									} catch (Exception e) {
										opcoesQuentes = "Sair";
									}
									switch (opcoesQuentes) {
										case "Forno":
											View.exibirMensagem("" + forno);
											break;
										case "MicroOndas":
											View.exibirMensagem("" + microOndas);
											break;
										case "Airfryer":
											View.exibirMensagem("" + airFryer);
											break;
									}
								} while (opcoesQuentes != "Sair");
								break;
							case "Coifas/Depurador":
								String opcoesCoifas = "";
								do {
									try {
										opcoesCoifas = View.menu("Coifas", "Depurador", "COIFAS/DEPURADOR","Informe o produto:");//Produtos de cada categoria
									} catch (Exception e) {
										opcoesCoifas = "Sair";
									}
									switch (opcoesCoifas) {
										case "Coifas":
											View.exibirMensagem("" + coifas);
											break;
										case "Depurador":
											View.exibirMensagem("" + depurador);
											break;
									}
								} while (opcoesCoifas != "Sair");
								break;
							case "Bebedouros":
								View.exibirMensagem("" + bebedouro);
								break;
						}

					} while (opcoesCategorias != "Sair");
					break;
			}
		} while (opcoesMenu != "Sair");
		// ------------------------------------------------//
	}

	public static void carrinho(ArrayList<Produtos> produtos, Usuario u, int opcoesMenuPrincipal) {
		String opcoesCarrinho = "";
		int valor = 0;
		ArrayList<Produtos> carrinho = new ArrayList<Produtos>();

		do {
			String listaDeCompras = "";
			int i = 0;
			// ----------------------------------// A lista de carrinho/favoritos/presentes
			switch (opcoesMenuPrincipal) {
			case 1:
				i = 0;
				if (!carrinho.isEmpty()) {
					for (Produtos carrinho2 : carrinho) {
						i++;
						listaDeCompras += "\n[" + i + "]" + carrinho2.getNome() + ", " + carrinho2.getPreco() + "R$\n";
					}
				} else {
					listaDeCompras = "vazio";
				}
				break;
			case 2:
				i = 0;
				if (!u.getFavoritos().isEmpty()) {
					for (Produtos favoritos : u.getFavoritos()) {
						i++;
						listaDeCompras += "\n[" + i + "]" + favoritos.getNome() + "\n";
					}
				} else {
					listaDeCompras = "vazio";
				}
				break;
			case 3:
				i = 0;
				if (!u.getPresentes().isEmpty()) {
					for (Produtos presentes : u.getPresentes()) {
						i++;
						listaDeCompras += "\n[" + i + "]" + presentes.getNome() + "\n";
					}
				} else {
					listaDeCompras = "vazio";
				}
				break;
			}
			// ----------------------------------// Menu adequado para cara situacao 
			try {
				if (carrinho.isEmpty() && opcoesMenuPrincipal == 1) //carrinho vazio
					opcoesCarrinho = View.menu("Adicionar", "CARRINHO", "opcoes");
				if (u.getFavoritos().isEmpty() && opcoesMenuPrincipal == 2)//favoritos vazio
					opcoesCarrinho = View.menu("Adicionar", "FAVORITO", "opcoes");
				if (u.getPresentes().isEmpty() && opcoesMenuPrincipal == 3)//presentes vazio
					opcoesCarrinho = View.menu("Adicionar", "PRESENTE", "opcoes");
				if (!carrinho.isEmpty() && opcoesMenuPrincipal == 1)//carrinho
					opcoesCarrinho = View.menu("Adicionar", "Remover", "Listar", "Comprar", "CARRINHO","Valor:" + valor + "\n\nopcoes");
				if (!u.getFavoritos().isEmpty() && opcoesMenuPrincipal == 2)//favoritos
					opcoesCarrinho = View.menu("Adicionar", "Remover", "Listar", "Adicionar Ao Carrinho", "FAVORITO","\n\nopcoes");
				if (!u.getPresentes().isEmpty() && opcoesMenuPrincipal == 3)//presentes
					opcoesCarrinho = View.menu("Adicionar", "Remover", "Listar", "Adicionar Ao Carrinho", "PRESENTE","\n\nopcoes");
			} catch (Exception e) {
				opcoesCarrinho = "Sair";
			}
			switch (opcoesCarrinho) {
				case "Adicionar":
					int opcoes = 0, y;
					String listaAux = "";
					do {
						listaAux = "";
						y = 0;
						for (Produtos produtosOrigem : produtos) {
							y++;
							listaAux += "[" + y + "]" + "|Nome:" + produtosOrigem.getNome() + "  Preco: " + produtosOrigem.getPreco() + "\n";//gera a lista de produtos no sistema e seus id's 
							if (y == opcoes) {
								switch (opcoesMenuPrincipal) {
								case 1:
									carrinho.add(produtosOrigem); //Adiciona ao carrinho
									valor += produtosOrigem.getPreco();
									break;
								case 2:
									u.getFavoritos().add(produtosOrigem);//Adiciona a lista de favoritos
									break;
								case 3:
									u.getPresentes().add(produtosOrigem);//Adiciona a lista de presentes
									break;
								}
							}
							listaAux += "-\n";
						}
						try {
							opcoes = View.inserirInt("ADICIONAR", listaAux + "\n\nOpcoes:");
						} catch (Exception e) {
							opcoes = 0;
						}
					} while (opcoes != 0);
					break;
				case "Remover":
					int remover = 0;
					do {
						try {
							remover = View.inserirInt("REMOVER", listaDeCompras + "\n\nnOpcoes:"); // com a lista de carrinho/favoritos/presentes ele pega o id e depois busca pelo id dele na lista - 1
							if (remover != 0) {
								switch (opcoesMenuPrincipal) {
								case 1://Remove do carrinho
									valor -= carrinho.get(remover - 1).getPreco();
									View.exibirMensagem(carrinho.get(remover - 1).getNome() + " Excluido com sucesso");
									carrinho.remove(carrinho.get(remover - 1));
									break;
								case 2://remove do favoritos
									u.getFavoritos().remove(u.getFavoritos().get(remover -1));
									View.exibirMensagem(u.getFavoritos().get(remover -1).getNome() + " Excluido com sucesso");
									break;
								case 3://remove do presentes
									u.getPresentes().remove(u.getPresentes().get(remover-1));
									View.exibirMensagem(u.getPresentes().get(remover -1).getNome() + " Excluido com sucesso");
									break;
								}
								remover = 0;
							}
						} catch (Exception e) {
							remover = 0;
						}
					} while (remover != 0);
					break;
				case "Listar":
					switch (opcoesMenuPrincipal) {
					case 1://Lista o carrinho
						View.exibirMensagem("" + carrinho);
						break;
					case 2://Lista os favoritos
						View.exibirMensagem("" + u.getFavoritos());
						break;
					case 3://Lista os presentes
						View.exibirMensagem("" + u.getPresentes());
						break;
					}
					break;
				case "Adicionar Ao Carrinho":
					switch (opcoesMenuPrincipal) {
					case 2:
						carrinho.addAll(u.getFavoritos()); //passa todo os favoritos para o carrinho
						for (Produtos produtosAddPreco : u.getFavoritos()) { //adiciona os seus devidos valores
							valor += produtosAddPreco.getPreco();
						}
						u.getFavoritos().clear(); //limpa
						View.exibirMensagem("Transferido!"); //informa o usuario
						opcoesMenuPrincipal = 1; //troca para o carrinho
						break;
					case 3:
						carrinho.addAll(u.getPresentes()); // O mesmo de cima so que com presentes
						for (Produtos produtosAddPreco : u.getFavoritos()) {
							valor += produtosAddPreco.getPreco();
						}
						u.getPresentes().clear();
						View.exibirMensagem("Transferido!");
						opcoesMenuPrincipal = 1;
						break;
					}
					break;
				case "Comprar":
					String op = "";
					int x = 0;
					if (View.confirmacao("COMPRAR",
							listaDeCompras + "\n\nValor:" + valor + "\nDeseja confirmar a compra?") == 0) {
						// Se tiver dois cartoes
						if (u.getCartoes().size() > 1) { // Se tiver mais de um cartao registrado
							do {
								String auxCartao = "";
								try {
									op = View.menu("Cartao", "Cartoes", "PAGAR", "Informe o metodo");
								} catch (Exception e) {
									op = "Sair";
								}
								switch (op) {
									case "Cartao"://Pagar com um cartao
										int opCartao1 = 1;
										int opcoesCartao1 = 0;
										do {
											auxCartao = "";
											x = 0;
											for (Cartao cartao : u.getCartoes()) {
												x++;
												auxCartao += "[" + x + "]" + cartao.getTipo() + " - "
														+ cartao.getSaldo() + "R$\n";
												if ((opcoesCartao1) == x) {
													if (cartao.getTipo() == "Debito") {
														valor -= (valor * 0.05);
														cartao.retirarSaldo(valor); // desconto se for a vista
													} else {
														cartao.retirarSaldo(valor);
													}
													View.exibirMensagem("Cartao ACEITO");
													opCartao1 = 0;
													op = "Sair";
												}
												auxCartao += "\n";
											}
											if (opCartao1 == 1) {
												try {
													opcoesCartao1 = View.inserirInt("PAGAR",auxCartao + "\nEscolha o cartao:");
												} catch (Exception e) {
													opCartao1 = 0;
												}
											}
										} while (opCartao1 != 0);
										break;
									case "Cartoes"://Pagar com dois cartao
										auxCartao = "";
										int opCartao2 = 1, opcoesCartao2 = 0, opcoesCartao3 = 0;
										do {
											boolean ok = false;
											x = 0;
											valor = valor / 2;// Divide o valor
											for (Cartao cartao : u.getCartoes()) {
												x++;
												auxCartao += "[" + x + "]" + cartao.getTipo() + " - "+ cartao.getSaldo() + "R$\n";
												if (opcoesCartao2 == x) {
													if (cartao.getTipo() == "Debito") {
														valor -= (valor * 0.05);
														cartao.retirarSaldo(valor); // desconto se for a vista
													} else {
														cartao.retirarSaldo(valor);
													}
													View.exibirMensagem("Primeiro cartao ACEITO");
													ok = true;
												}
												if (opcoesCartao3 == x) {
													if (cartao.getTipo() == "Debito") {
														valor -= (valor * 0.05);
														cartao.retirarSaldo(valor); // desconto se for a vista
													} else {
														cartao.retirarSaldo(valor);
													}
													View.exibirMensagem("Segundo cartao ACEITO");
													if (ok == true) {
														opCartao2 = 0;
														op = "Sair";
													}
												}
												auxCartao += "\n";
											}
											if (opCartao2 == 1) {
												try {
													opcoesCartao2 = View.inserirInt("PAGAR",auxCartao + "\nEscolha o 1 - cartao:");
													opcoesCartao3 = View.inserirInt("PAGAR",auxCartao + "\nEscolha o 2 - cartao:");
												} catch (Exception e) {
													opCartao2 = 0;
												}
											}
										} while (opCartao2 != 0);
										break;
								}
							} while (op != "Sair");
						} else {// Se tiver um cartao registrado
								// ------------
							for (Cartao cartao : u.getCartoes()) {
								if (cartao.getTipo() == "Debito") {
									valor -= (valor * 0.05);
									cartao.retirarSaldo(valor); // compras a vista tem 5% de desconto
								} else {
									cartao.retirarSaldo(valor);
								}
								View.exibirMensagem("Cartao ACEITO");
							}
							// ------------
						}
						valor = 0;//reseta o valor
						carrinho.clear();//limpa o carrinho
						retiradas(u, listaDeCompras);//passa a responsabilidade para a entragadora/retirada ou agendamento
					}
					break;
			}
		} while (opcoesCarrinho != "Sair");
	}

	public static void retiradas(Usuario usuario, String listaDeCompras) {
		String opcoes = "";
		do {
			try {
				if (usuario.getEnderecos().size() >= 1)//verifica se tem endereco (a final como vai agendar ou entregar sem endereco)
					opcoes = View.menu("Retirar Na Loja", "Entregar", "Agendar", "RETIRADAS", "opcoes");
				else
					opcoes = View.menu("Retirar Na Loja", "RETIRADAS", "opcoes");
			} catch (Exception e) {
				opcoes = "Sair";
			}
			switch (opcoes) {
				case "Retirar Na Loja": //gera um codigo para retirar na loja
					int codigo = Utils.randomInRangeInt(0, 15000);
					View.exibirMensagem("Se dirija a loja mais proxima e ultilize o codigo:" + codigo+ "\n\nCaso perca o codigo, ele está salvo nas suas compras(Usuario)");
					usuario.getPedidos().add(listaDeCompras + "\nCodigo:" + codigo);//LOG
					break;
				case "Agendar":
				case "Entregar":
					int op = -1;
					do {
						try {
							op = View.inserirInt("RETIRAR", usuario.getEnderecos() + "\nEscolha o endereco:");
							if (opcoes == "Entregar")
								usuario.getPedidos().add(listaDeCompras + "\nEndereco:" + usuario.getEnderecos().get(op));// LOG 
							if (opcoes == "Agendar") {
								int data = View.inserirInt("AGENDAMENTO", "Informe apenas o dia:");//informe a data
								usuario.getPedidos().add(listaDeCompras + "\nEndereco:" + usuario.getEnderecos().get(op)+ "\nDia:" + data);// LOG 
							}
							View.exibirMensagem("Qualquer coisa entramos em contato no numero:" + usuario.getTelefone());
						} catch (Exception e) {
							op = 0;
						}
					} while (op != 0);
					break;
			}
		} while (opcoes != "Sair");
	}
}
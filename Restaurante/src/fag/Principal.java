package fag;

import fag.objetos.Pedido;

public class Principal {

	public static void main(String[] args) {
		Pedido ped = new Pedido("João");
		ped.adicionarLanches(3);
		ped.exibirPedido();

	}

}

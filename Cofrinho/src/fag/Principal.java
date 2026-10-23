package fag;

import fag.objetos.Cofrinho;

public class Principal {
	public static void main(String[] args) {
		Cofrinho cof = new Cofrinho("João", 500);
		cof.depositar(100);
		cof.depositar(500);
		cof.retirar(1000);
		cof.exibirSaldo();
		cof.getDono();
		cof.verificarMeta();
	}

}

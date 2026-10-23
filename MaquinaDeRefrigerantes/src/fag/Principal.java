package fag;

import fag.objetos.MaquinaRefrigerante;

public class Principal {
	public static void main(String ars[]){
		MaquinaRefrigerante maquina = new MaquinaRefrigerante(10);
		maquina.comprar(4, 10);
		maquina.comprar(4, 20);
		maquina.exibirEstado();
}

}

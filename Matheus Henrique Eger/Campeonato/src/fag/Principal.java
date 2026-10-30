package fag;

import fag.objetos.Time;

public class Principal {
	public static void main(String[] args) {
		Time gremio = new Time("Grêmio");
		Time inter = new Time("Internacional");
		
		for (int i=0; i<100; i++) {
			gremio.registrarEmpate();
		}
		for (int i=0; i<100; i++) {
			inter.registrarEmpate();
		}
		if (gremio.getPontos() == inter.getPontos()) {
			System.out.println("Houve empate na classificação, nenhum time ganhou. :(");
		}
		if (gremio.getPontos() > inter.getPontos()) {
			System.out.println(gremio.getNome() + " Ganhou a temporada! Parabéns pelos "+gremio.getPontos());
		}
		if (inter.getPontos() > gremio.getPontos()) {
			System.out.println(inter.getNome() + " Ganhou a temporada! Parabéns pelos "+inter.getPontos());
		}
	}
}

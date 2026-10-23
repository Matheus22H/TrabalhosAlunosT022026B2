package fag;

import java.util.Scanner;
import fag.objects.Estacionamento;

public class Main {
	public static void main(String[] args) {
		Scanner scania = new Scanner(System.in);
		System.out.println("Insira a placa do veículo: ");
		String placa = scania.nextLine();
		System.out.println("Insira o modelo do veículo: ");
		String modelo = scania.nextLine();
		Estacionamento variavel = new Estacionamento(placa, modelo);
		System.out.println("O caba tá ai há quanto tempo? ");
		variavel.adicionarTempo(scania.nextInt());
		variavel.exibirResumo();
		
		scania.close();
	}
}

package fag.objetos;

public class MaquinaRefrigerante {
	private int quantidadeEstoque;
	private float dinheiroArrecadado;
	private static float preco=4.5f;
	public MaquinaRefrigerante() {
		setQuantidadeEstoque(0);
		setDinheiroArrecadado(0);
	}
	public MaquinaRefrigerante(int estoque) {
		setQuantidadeEstoque(estoque);
		setDinheiroArrecadado(0);
	}
	public MaquinaRefrigerante(int estoque, float dinheiro) {
		setQuantidadeEstoque(estoque);
		setDinheiroArrecadado(dinheiro);
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if(quantidadeEstoque > 0) {
		this.quantidadeEstoque = quantidadeEstoque;
		}
	}
	public void reporEstoque(int quantidade) {
		if (quantidade > 0 ) {
		this.quantidadeEstoque += quantidade;
		}
		
	}
	public float getDinheiroArrecadado() {
		return dinheiroArrecadado;
	}
	public void setDinheiroArrecadado(float dinheiroArrecadado) {
		this.dinheiroArrecadado = dinheiroArrecadado;
	}
	private void addDinheiroArrecadado(float dinheiroArrecadado) {
		this.dinheiroArrecadado += dinheiroArrecadado;
	}
	
	public float comprar(int quantidade, float valorPago) {
		float operacao = quantidade*preco;
		if (quantidade <=0) {
			System.out.println("Quantia inserida, inválida. Tente novamente.");
			return valorPago;
		}
		if (valorPago < operacao) {
			System.out.println("O valor inserido é menor do que o valor dos produtos. Tente novamente.");
			return valorPago;
		}
		if (quantidade > quantidadeEstoque) {
			System.out.println("Nosso estoque é menor que a quantidade desejada. Tente novamente.");
			return valorPago;
		}
		float troco = (valorPago - operacao);
		setQuantidadeEstoque(quantidadeEstoque - quantidade);
		addDinheiroArrecadado(operacao);
		System.out.println("Obrigado por comprar " + quantidade + " refrigerantes por R$ "+ operacao + ", seu troco é de R$ "+ troco);
		return troco;
		
	}
	public void exibirEstado() {
		System.out.println("A quantidade de estoque atual é:" + quantidadeEstoque);
		System.out.println("O valor arrecador atual é:" + dinheiroArrecadado);
	}
}

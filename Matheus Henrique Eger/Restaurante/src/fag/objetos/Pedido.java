package fag.objetos;

public class Pedido {
	private String nomeCliente;
	private int quantidadeLanches;
	private boolean status=true;
	private static float precoLanche = 18.0f;
	private static float taxaEntrega = 7.0f;
	private static int pedidosPara10Porcento = 3;
	public void setNome(String nome) {
		this.nomeCliente = nome;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Pedido() {}
	public Pedido(String nome) {
		setNome(nome);
	}
	public void adicionarLanches(int quantidade) {
		if (!status) {
			System.out.println("Pedido inalterado: Já finalizado!");
			return;
		}
		if (quantidade <= 0) {
			System.out.println("Pedido inalterado: Quantia inválida!");
			return;
		}
		this.quantidadeLanches += quantidade;
	}
	public float calcularTotal() {
		if (quantidadeLanches >= pedidosPara10Porcento) {
			return ((quantidadeLanches * precoLanche) * 0.9f) + taxaEntrega;
		}
		else {
			return (quantidadeLanches * precoLanche) + taxaEntrega;
		}
	}
	public void finalizarPedido() {
		System.out.println("Pedido finalizado!");
		setStatus(false);
	}
	public void exibirPedido() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Nome do cliente: "+ this.nomeCliente);
		if (status) {
			System.out.println("Status do pedido: Finalizado.");
		}
		else {
			System.out.println("Status do pedido: Em aberto.");
		}
		System.out.println(quantidadeLanches + "x Lanches = " + quantidadeLanches * precoLanche);
		System.out.println("Taxa de entrega = " + taxaEntrega);
		if (quantidadeLanches >= pedidosPara10Porcento) {
			System.out.printf("Desconto = %.2f \n", (calcularTotal() - (quantidadeLanches * precoLanche) - taxaEntrega));
		}
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Total = " + calcularTotal());
		System.out.println("----------------------------------------------------obrigado!-------");
	}
	//exibirPedido()

}

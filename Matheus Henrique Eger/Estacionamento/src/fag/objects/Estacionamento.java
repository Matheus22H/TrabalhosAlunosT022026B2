package fag.objects;

public class Estacionamento {
	private String placa;
	private String modelo;
	private int minutosEstacionado;
	private float valorPago;
	private static float base = 5;
	private static int minutoBase = 30;
	private static float incremento = 0.1f;
	private static float maximo = 30;
	public Estacionamento() {
		setPlaca("AAAA0A00");
		setModelo("SEM MODELO");
		setMinutosEstacionado(0);
		setValorPago(0);
	}
	public Estacionamento(String placa) {
		setPlaca(placa);
		setModelo("SEM MODELO");
		setMinutosEstacionado(0);
		setValorPago(0);
	}
	public Estacionamento(String placa, String modelo) {
		setPlaca(placa);
		setModelo(modelo);
		setMinutosEstacionado(0);
		setValorPago(0);
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getMinutosEstacionado() {
		return minutosEstacionado;
	}
	public void setMinutosEstacionado(int minutosEstacionado) {
		this.minutosEstacionado = minutosEstacionado;
	}
	public float getValorPago() {
		return valorPago;
	}
	public void setValorPago(float valorPago) {
		this.valorPago = valorPago;
	}
	public void adicionarTempo(int minutos) {
		if (minutos > 0) {
			this.minutosEstacionado += minutos;
		}
	}
	public float calcularValor() {
		setValorPago(base + ((getMinutosEstacionado()-minutoBase) * incremento));
		if (getMinutosEstacionado() <= minutoBase) {
			setValorPago(base);	
		}
		if (getValorPago() > maximo) {
			setValorPago(maximo);
		}
		return getValorPago();
	}
	public void exibirResumo() {
		calcularValor();
		System.out.println("Carro de placa: " + getPlaca() + " e o modelo: " + getModelo() + ", está no estacionamento há " + getMinutosEstacionado() + " minutos e pagara: R$ " + getValorPago());
	}
}

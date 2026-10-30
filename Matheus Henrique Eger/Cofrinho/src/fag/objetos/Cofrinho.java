package fag.objetos;

public class Cofrinho {
	private String dono;
	private float saldo;
	private float metaEconomia;
	public String getDono() {
		return dono;
	}
	public void setDono(String dono) {
		this.dono = dono;
	}
	public float getSaldo() {
		return saldo;
	}
	public float getMetaEconomia() {
		return metaEconomia;
	}
	public void setMetaEconomia(float metaEconomia) {
		if (metaEconomia > 0) {
			this.metaEconomia = metaEconomia;
		}
	}
	public Cofrinho() {}
	public Cofrinho(String dono) {
		setDono(dono);
	}
	public Cofrinho(String dono, float meta) {
		setDono(dono);
		setMetaEconomia(meta);
	}
	public void depositar(float valor) {
		if (valor <= 0) {
			System.out.println("Valor inválido!");
			return;
		}
		this.saldo += valor;
	}
	public void retirar(float valor) {
		if (valor <= 0) {
			System.out.println("Valor inválido!");
			return;
		}
		if (valor > saldo) {
			System.out.println("Saldo insuficiente!");
			return;
		}
		saldo -= valor;
		System.out.println("Foi sacado R$ "+valor+" com sucesso!");
	}
	public void verificarMeta() {
		if (saldo < metaEconomia) {
			System.out.println("Faltam R$ "+ (metaEconomia - saldo) +" para alcançarmos a meta de "+ metaEconomia);			
		}
		else {		
			System.out.println("Atingimos a meta de R$ "+ metaEconomia +", e ainda está sobrando R$ "+ (saldo-metaEconomia));
		}
	}
	public void exibirSaldo() {
		System.out.println("O saldo atual é de R$ "+ getSaldo());
	}


}

package fag.objetos;

public class Time {
	private String nome;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int pontos;
	public Time() {}
	public Time(String nome) {
		setNome(nome);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		if (vitorias > 0) {
			this.vitorias = vitorias;
		}
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		if (empates > 0) {
			this.empates = empates;
		}
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		if (derrotas > 0){
			this.derrotas = derrotas;
		}
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		if (pontos > 0) {
			this.pontos = pontos;
		}
	}
	public void registrarVitoria() {
		this.vitorias += 1;
		this.pontos += 3;
	}
	public void registrarDerrota() {
		this.derrotas += 1;
	}
	public void registrarEmpate() {
		this.empates += 1;
		this.pontos += 1;
	}
	public void exibirEstatisticas() {
		System.out.println("Exibindo Estatísticas para o time: "+nome);
		System.out.println("Vitórias: "+ vitorias);
		System.out.println("Derrotas: "+ derrotas);
		System.out.println("Empates: "+ empates);
		System.out.println("E seus pontos da temporada são: "+ pontos);
	}
}

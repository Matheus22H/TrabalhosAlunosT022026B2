package biblioteca.objetos;

import java.util.ArrayList;
import java.util.List;
import biblioteca.objetos.Livro;
public class Pessoa {
	private String nome;
	private List<Livro> livrosAlugados;
	
	public Pessoa() {
	}
	public Pessoa(String nome) {
		setNome(nome);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Livro> getLivrosAlugados() {
		return livrosAlugados;
	}
	public void setLivrosAlugados(List<Livro> livrosAlugados) {
		this.livrosAlugados = livrosAlugados;
	}
	public void addLivroAlugado(Livro livro) {
		if (this.livrosAlugados != null) {			
			this.livrosAlugados.add(livro);
			return;
		}
		this.livrosAlugados = new ArrayList<Livro>();
		addLivroAlugado(livro);
	}
		
}

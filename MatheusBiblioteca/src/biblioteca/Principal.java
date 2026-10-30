package biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import biblioteca.objetos.Livro;
import biblioteca.objetos.Pessoa;
public class Principal {
	static Scanner scania = new Scanner(System.in);
	static List<Livro> listaLivros = new ArrayList<Livro>();
	static List<Pessoa> listaUsuarios = new ArrayList<Pessoa>();
	static List<String> listaNomesImproprios = new ArrayList<String>();
	static int LIMITE_LIVROS = 2;
	private static void carregarDb() {
		listaLivros.add(new Livro("A volta dos que não foram", "Suspense"));
		listaLivros.add(new Livro("67 razões para farmar aura", "Romance"));
		listaLivros.add(new Livro("Pintinho que não tinha cu", "Aventura"));
		listaLivros.add(new Livro("O conto da meia noite: meia noite te conto", "Suspense"));
		listaLivros.add(new Livro("Minhocas paralíticas - Superação", "Autobiografia"));
		listaLivros.add(new Livro("Hiper homem (narvel copyright 2013)", "SCI-FI"));
		listaLivros.add(new Livro("Poeira em alto mar", "Drama"));
		listaLivros.add(new Livro("O rastro no rio", "Distopia"));
		listaLivros.add(new Livro("A banda das pulgas", "Infantil"));
		listaUsuarios.add(new Pessoa("José Bezerra"));
		listaUsuarios.add(new Pessoa("Clóvis Basílio"));
		listaUsuarios.add(new Pessoa("John Wick"));
		listaUsuarios.add(new Pessoa("Alceu dispor"));
		listaUsuarios.add(new Pessoa("Luis Picamoles"));
		listaUsuarios.add(new Pessoa("Milton Caraglio"));
		listaUsuarios.add(new Pessoa("Salamandra maniaca"));
		listaUsuarios.add(new Pessoa("Dom Pedro II"));
		listaNomesImproprios.add("boboca");
		listaNomesImproprios.add("bobalhao");
		listaNomesImproprios.add("batapimbas");
		listaNomesImproprios.add("bocó de molas");
		listaNomesImproprios.add("paspalho");
		listaNomesImproprios.add("cu");
	}
	public static void main(String[] args) {
		carregarDb();
		System.out.println("Banco inicializado.");
		menu();
	}
	public static void menu() {
		int escolha = 0;
		do {
			System.out.println("--------------------Selecione uma das opções--------------------");
			System.out.println("1 - Registrar usuario");
			System.out.println("2 - Listar usuarios");
			System.out.println("3 - Listar livros");
			System.out.println("4 - Cadastrar livros");
			System.out.println("5 - Excluir livros");
			System.out.println("6 - Locar livros");
			System.out.println("7 - Devolver livros");
			System.out.println("8 - Alterar limite (Atual: " + LIMITE_LIVROS + ")");
			System.out.println("0 - Saida");
			escolha = scania.nextInt();
			scania.nextLine();
			decidirEscolha(escolha);
		} while(escolha != 0);
		scania.close();
	}
	public static void decidirEscolha(int escolha) {
		switch (escolha) {
			case 0: {System.out.println("Obrigado por usar!"); break;}
			case 1: {registarUsuario(); break;}
			case 2: {listarUsuarios(); break;}
			case 3: {listarLivros(); break;}
			case 4: {cadastrarLivro(); break;}
			case 5: {excluirLivro(); break;}
			case 6: {alugarLivro(); break;}
			case 7: {devolverLivro(); break;}
			case 8: {alterarLimite(); break;}
			default: {System.out.println("Insira um valor válido!");}
		}
	}
	private static void alterarLimite() {
		System.out.println("Insira o novo limite:");
		int lim = scania.nextInt();
		scania.nextLine();
		if (lim > 0) {			
			LIMITE_LIVROS = lim;
			System.out.println("Limite alterado para " + lim);
			return;
		}
		System.out.println("Limite mantido em " + LIMITE_LIVROS + ", pois o inserido é inválido: " + lim);
	}
	private static void listarLivros() {
		for (int i = 0; i < listaLivros.size(); i++) {
			Livro obj = listaLivros.get(i);
			System.out.printf("%d) %s - %s / %s\n", i+1, obj.getNome(), obj.getGenero(), obj.validarDisponibilidade());
		}
		System.out.println("");
	}
	private static void listarUsuarios() {
		System.out.println("\n--------Lista Usuarios--------");
		for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.printf("%d) %s \n", i+1, listaUsuarios.get(i).getNome());
			Pessoa usuario = listaUsuarios.get(i);
			List<Livro> livros = usuario.getLivrosAlugados();
			
			// Reaproveitamento da lógica proveniente do Python, que por sinal tem aqui
			if(usuario.getLivrosAlugados() == null || usuario.getLivrosAlugados().size() == 0) {
				continue; 
			}
			
			for (int j = 0; j < livros.size(); j++) {
				Livro livro = livros.get(j);
				System.out.printf("  %d) %s - %s\n", j+1, livro.getNome(), livro.getGenero());
			}
		}
		System.out.println("------------------------------\n");
	}
	private static void registarUsuario() {
		System.out.println("Insira o nome do usuário: ");
		String nome = scania.nextLine();
		String[] nomes = nome.split(" ");
		boolean valido = true;
		for (String temp : nomes) {
			if (listaNomesImproprios.contains(temp.toLowerCase())) {
				valido = false;
			}
		}
		if (!valido) {
			System.out.println("Usuário contem palavras profanas e não foi cadastrado!");
			return;
		}
		listaUsuarios.add(new Pessoa(nome));
		System.out.println("Usuário adicionado com sucesso!");
	}
	private static void cadastrarLivro() {
		Livro livro = new Livro();
		System.out.println("Insira o titulo do livro: ");
		livro.setNome(scania.nextLine());
		
		System.out.println("Insira o genero do livro: ");
		livro.setGenero(scania.nextLine());
		
		listaLivros.add(livro);
	}
	private static void excluirLivro() {
		if (listaLivros.size() == 0) {
			System.out.println("Não há o que excluir.");
			return;
		}
		listarLivros();
		System.out.println("Selecione o ID do livro que quer deletar:");
		int escolha = scania.nextInt()-1;
		if (escolha >= listaLivros.size()) {
			System.out.println("Como que tu vai deletar um item que não existe?");
			return;
		}
		Livro livro = listaLivros.get(escolha);
		if(livro.getDataLocacao() != null) {
			System.out.println("O livro tem pendencias, portanto não pode ser excluido!");
			return;
		}
		listaLivros.remove(escolha);
		System.out.println("Livro '" + livro.getNome() + "' removido!");
	}
	private static int resolveUserID(String any) {
		String numeros = "0123456789";
		boolean valido = true;
		for (int i = 0; i < any.length(); i++) {
			char ch = any.charAt(i);
			if (!numeros.contains(String.valueOf(ch))) {
				valido=false;
			}
		}
		if (valido) {
			return Integer.valueOf(any) -1;				
		}
		return resolveUserName(any);
	}
	private static int resolveUserName(String nome) {
		List<Pessoa> listaTemp = new ArrayList<Pessoa>();
		for (Pessoa pess : listaUsuarios) {
			if (!pess.getNome().contains(nome)) {
				continue;
			}
			listaTemp.add(pess);
		}
		if (listaTemp.size() < 1) {
			return -1;
		}
		if (listaTemp.size() == 1) {
			return listaUsuarios.indexOf(listaTemp.get(0));
		}
		for (Pessoa pess : listaTemp) {
			System.out.println((listaUsuarios.indexOf(pess) +1) + ") "+ pess.getNome());
		}
		System.out.println("Por favor, queira especificar qual pessoa que você quer (ID):");
		return scania.nextInt()-1;
	}
	private static void alugarLivro() {
		listarUsuarios();
		System.out.println("Insira o id ou nome do usuário:");
		int id = resolveUserID(scania.nextLine());
		if (id < 0 || id > listaUsuarios.size()) {
			System.out.println("Usuário inválido!");
			return;
		}
		Pessoa pessoa = listaUsuarios.get(id);
		
		List<Livro> livros = new ArrayList<Livro>();
		if (pessoa.getLivrosAlugados() != null) {
			livros.addAll(pessoa.getLivrosAlugados());
		}
		if (livros.size() >= LIMITE_LIVROS) {
			System.out.println("O "+ pessoa.getNome() + " não pode ter mais livros alugados, pois já tem os livros:");
			for (Livro livro : livros) {
				System.out.println(" - '" + livro.getNome() + "'");
			}
			System.out.println("E nosso limite atual é de "+ LIMITE_LIVROS + " livro(s).");
			return;
		}
		listarLivros();
		System.out.println("Selecione o ID do livro que quer alugar:");
		int lid = scania.nextInt()-1;
		if (lid < 0 || lid >= listaLivros.size()) {
			System.out.println("Livro inválido.");
			return;
		}
		Livro livro = listaLivros.get(lid);
		if (livro.getDataLocacao() != null) {
			System.out.println("Este livro já está alugado!");
			return;
		}
		livro.setDataLocacao(new Date());
		pessoa.addLivroAlugado(livro);
		System.out.println("Livro '"+livro.getNome()+"'alugado para: " + pessoa.getNome());
	}
	private static void devolverLivro() {
		listarUsuarios();
		System.out.println("Insira o id ou nome do usuário:");
		int id = resolveUserID(scania.nextLine());
		if (id < 0 || id >= listaUsuarios.size()) {
			System.out.println("Usuário inválido!");
			return;
		}
		Pessoa pessoa = listaUsuarios.get(id);
		if (pessoa.getLivrosAlugados() == null) {
			System.out.println(pessoa.getNome() + " não possuí livros para devolver.");
			return;
		}
		List<Livro> livros = pessoa.getLivrosAlugados();
		for (int i = 0; i < livros.size(); i++) {
			Livro livro = livros.get(i);
			System.out.println((i+1) +") "+ livro.getNome());
		}
		System.out.println("Esta pessoa possui estes livros, qual ela vai devolver (ID)?");
		int lid = scania.nextInt()-1;
		if (lid < 0 || lid >= livros.size()) {
			System.out.println("Livro inválido.");
			return;
		}
		Livro livro = livros.get(lid);
		livro.setDataLocacao(null);
		livros.remove(lid);
		pessoa.setLivrosAlugados(livros);
		System.out.println("Removido: '"+ livro.getNome() + "' da lista de: "+ pessoa.getNome());
	}
}

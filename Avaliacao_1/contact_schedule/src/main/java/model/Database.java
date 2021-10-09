package model;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private static Database instance;


	private List<Usuario> listaUsuarios = new ArrayList<>();
	public Usuario user = null;
	public Integer idContato;

	private Database(){};

	{
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(new Endereco("Rua Jose Vieira Lima", "50", "CC", "Presidente Medice", "5821383", "CG", "PB"));
		enderecos.add(new Endereco("Rua Pedro da Costa Agra", "237", "CC", "José Pinheiro", "5840720", "CG", "PB"));
		
		List<Contato> contatos = new ArrayList<>();
		contatos.add(new Contato("Moabe", "11111111", "222222", enderecos));

		Usuario usuario = new Usuario("Moabe", "teste", "teste", contatos);
		
		adicionarUsuario(usuario);

	}


	public static Database getInstante() {
		if (instance == null) {
			instance = new Database();
		}

		return instance;
	}

	public void adicionarUsuario(Usuario user) {
		this.listaUsuarios.add(user);
	}
	
	
	public Usuario existeUsuario(String login, String senha) {
		for(Usuario u : listaUsuarios) {
			if(u.validarLogin(login, senha)) {
				user = u;
				return u;
			}
		}
		return null;
	}
	

	public Contato buscaContatoPeloId(Integer id) {
		for(Contato contato : user.getContatos()) {
			if(contato.getId() == id) {
				return contato;
			}
		}
		return null;
	}
	
	public void removeContato(Integer id) {
		for(int i = 0; i < user.getContatos().size(); i++) {
			if(user.getContatos().get(i).getId().equals(id)) user.getContatos().remove(i);
		}
	}
	
}

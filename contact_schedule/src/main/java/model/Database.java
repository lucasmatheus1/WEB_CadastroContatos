package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private static List<UserModel> listaUsuarios = new ArrayList<>();
	private static List<ContactModel> listaContatos = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		UserModel user = new UserModel("teste", "teste@teste.com", "teste");
		listaUsuarios.add(user);
		
		List<AddressModel> listaEnderecos = new ArrayList<>();
		
		listaEnderecos.add(new AddressModel(
				"Rua Pedro da Costa Agra",
				237,
				"F",
				"Paraíba",
				"Campina Grande",
				"PB"
				));
		
		listaEnderecos.add(new AddressModel(
				"Rua Pedro",
				2327,
				"F",
				"Pdsada",
				"Cadsadna Grande",
				"sddsB"
				));
		
		ContactModel contato = new ContactModel(
				chaveSequencial, 
				"Moabe Barbosa", 
				12312312, 
				3123123, 
				listaEnderecos
				);
		
		listaContatos.add(contato);
	}

	public UserModel existeUsuario(String login, String senha) {
		for(UserModel u : listaUsuarios) {
			if(u.validarLogin(login, senha)) {
				return u;
			}
		}
		return null;
	}
	
	
	public void adicionarUsuario(UserModel user) {
		Database.listaUsuarios.add(user);
	}
	
	public List<ContactModel> getContatos() {
		return Database.listaContatos;
	}
	
	public void adicionarContato(ContactModel contato) {
		Database.listaContatos.add(contato);
	}
}

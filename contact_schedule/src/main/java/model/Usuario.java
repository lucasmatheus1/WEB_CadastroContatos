package model;

import java.util.List;

public class Usuario {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private List<Contato> contatos;

	
	public Usuario(String name, String email, String password, List<Contato> contatos) {
		super();
		this.id = GeradorId.getId();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contatos = contatos;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public void adicionarContato(Contato contato) {
		this.contatos.add(contato);
	}

	public Boolean validarLogin(String login, String senha) {
		if(!this.email.equals(login)) return false;
		return this.password.equals(senha);
	}
	
}

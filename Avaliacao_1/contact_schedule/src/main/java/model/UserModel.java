package model;

public class UserModel {
	private String name;
	private String email;
	private String password;
	
	
	public UserModel(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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
	
	public Boolean validarLogin(String login, String senha) {
		if(!this.email.equals(login)) return false;
		if(!this.password.equals(senha)) return false;
		return true;
	}
	
}

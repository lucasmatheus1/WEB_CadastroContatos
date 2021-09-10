package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;
import model.UserModel;

public class Cadastro implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		UserModel user = new UserModel(nome, email, senha);
				
		Database database = new Database();
		database.adicionarUsuario(user);
		
		return "redirect:entrada?acao=LoginForm";
		
	}

}

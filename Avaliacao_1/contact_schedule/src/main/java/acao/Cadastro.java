package acao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Database;
import model.Usuario;

public class Cadastro implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario(nome, email, senha, new ArrayList<Contato>());
				
		Database database = Database.getInstante();
		database.adicionarUsuario(user);
		
		return "redirect:entrada?acao=LoginForm";
		
	}

}

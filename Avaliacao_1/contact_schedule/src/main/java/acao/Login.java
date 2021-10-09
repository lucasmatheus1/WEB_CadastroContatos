package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;
import model.Usuario;

public class Login implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando " + login);
		
		Database database = Database.getInstante();
		Usuario usuario = database.existeUsuario(login, senha);
		
		if(usuario != null) {
			System.out.println("Logando existe");
			return "redirect:entrada?acao=Dashboard";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}
		
		
	}

}

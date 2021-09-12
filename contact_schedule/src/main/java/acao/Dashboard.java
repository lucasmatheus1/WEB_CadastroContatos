package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Contato;
import model.Database;

public class Dashboard implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Database database = Database.getInstante();
		
		List<Contato> contatos = database.user.getContatos();
		request.setAttribute("contatos", contatos);
		return "forward:dashboard.jsp";
	}

}

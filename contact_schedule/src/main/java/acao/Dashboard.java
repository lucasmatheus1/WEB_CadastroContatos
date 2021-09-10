package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContactModel;
import model.Database;

public class Dashboard implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("DASHBOARD");
		
		Database database = new Database();
		
		List<ContactModel> lista = database.getContatos();
		request.setAttribute("contatos", lista);
		return "forward:dashboard.jsp";
	}

}

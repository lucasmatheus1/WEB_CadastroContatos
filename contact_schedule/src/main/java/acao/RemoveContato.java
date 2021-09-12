package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;

public class RemoveContato implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Remover contato: " + id);
		
		Database database = Database.getInstante();
		database.removeContato(id);
		return "redirect:entrada?acao=Dashboard";
	}

}

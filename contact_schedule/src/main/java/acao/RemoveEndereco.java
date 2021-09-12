package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;

public class RemoveEndereco implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Remover endereço: " + id);
		
		Database database = Database.getInstante();
		database.buscaContatoPeloId(database.idContato).removeEndereco(id);
		
		
		return "redirect:entrada?acao=Dashboard2&id=" + database.idContato.toString();
	}

}

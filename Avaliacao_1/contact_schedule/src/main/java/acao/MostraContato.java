package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Database;

public class MostraContato implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = Database.getInstante();
		
		Contato contato = database.buscaContatoPeloId(id);
		
		request.setAttribute("contato", contato);
		
		return "forward:formAlteraContato.jsp";
	}

}

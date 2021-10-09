package acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;
import model.Endereco;

public class Dashboard2 implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = Database.getInstante();
		database.idContato = id;
		System.out.println("ID: " + id);
		List<Endereco> enderecos = database.buscaContatoPeloId(id).getEnderecos();
		request.setAttribute("enderecos", enderecos);
		request.setAttribute("id", id);
		
	
		return "forward:dashboard2.jsp";
	}

}

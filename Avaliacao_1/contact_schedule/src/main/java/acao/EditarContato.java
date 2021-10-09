package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Database;

public class EditarContato implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		String nome = request.getParameter("nome");
		String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
		
		Database database = Database.getInstante();
		Contato contato = database.buscaContatoPeloId(id);
		contato.setCpf(cpf);
		contato.setNome(nome);
		contato.setRg(rg);
		
		request.setAttribute("contato", contato);
		
		return "redirect:entrada?acao=Dashboard";
	}

}

package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Database;
import model.Endereco;

public class MostrarEndereco implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Database database = Database.getInstante();
		System.out.println("MOSTRANDO ENDERE�O");
		System.out.println("MOSTRANDO ENDERE�O: " + database.idContato);
		Contato contato = database.buscaContatoPeloId(database.idContato);
		
		Endereco endereco = contato.buscaEnderecoPeloId(id);
		System.out.println("MOSTRANDO ENDERE�O: " + endereco);
		request.setAttribute("endereco", endereco);
		
		return "forward:formAlteraEndereco.jsp";
	}

}

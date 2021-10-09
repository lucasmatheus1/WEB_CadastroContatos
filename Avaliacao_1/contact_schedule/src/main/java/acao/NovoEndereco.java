package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Database;
import model.Endereco;

public class NovoEndereco implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Adicionar Endereço");
		
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		Endereco endereco = new Endereco(
				rua,
				numero,
				complemento,
				bairro,
				cep,
				cidade,
				estado
			); 
		
		Database database = Database.getInstante();
		database.buscaContatoPeloId(database.idContato).adicionarEndereco(endereco);
		
		return "redirect:entrada?acao=Dashboard2&id=" + database.idContato.toString();
	}

}

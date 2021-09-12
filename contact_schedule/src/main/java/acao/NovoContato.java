package acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import model.Contato;
import model.Database;

public class NovoContato implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		
		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(new Endereco(
				rua,
				numero,
				complemento,
				bairro,
				cep,
				cidade,
				estado
			));
		
		
		Contato contato = new Contato(
				nome,
				rg,
				cpf,
				enderecos
		);
		
		Database database  = Database.getInstante();
		database.user.adicionarContato(contato);
		
		return "redirect:entrada?acao=Dashboard";
	}

}

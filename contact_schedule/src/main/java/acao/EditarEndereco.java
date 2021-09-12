package acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contato;
import model.Database;
import model.Endereco;

public class EditarEndereco implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("AIIAIAIAIIAIAIAI");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String bairro = request.getParameter("bairro");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		Database database = Database.getInstante();
		Contato contato = database.buscaContatoPeloId(database.idContato);
		Endereco endereco = contato.buscaEnderecoPeloId(id);
		
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		
		request.setAttribute("endereco", endereco);
		
		return "redirect:entrada?acao=Dashboard2&id=" + database.idContato.toString();
	}

}

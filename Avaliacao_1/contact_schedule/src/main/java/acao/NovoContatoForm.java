package acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoContatoForm implements acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "forward:formNovoContato.jsp";
	}

}

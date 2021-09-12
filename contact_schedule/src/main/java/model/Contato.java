package model;

import java.util.List;

public class Contato {
	
	private Integer id;
	private String nome;
	private String rg;
	private String cpf;
	private List<Endereco> enderecos;

	public Contato(String nome, String rg, String cpf, List<Endereco> enderecos) {
		this.id = GeradorId.getId();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.enderecos = enderecos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	public void adicionarEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}
	
	public Endereco buscaEnderecoPeloId(Integer id) {
		for(Endereco endereco : this.enderecos) {
			if(endereco.getId() == id) {
				return endereco;
			}
		}
		return null;
	}
	
	public void removeEndereco(Integer id) {
		for(int i = 0; i < this.enderecos.size(); i++) {
			if(enderecos.get(i).getId().equals(id)) enderecos.remove(i);
		}
	}


	@Override
	public String toString() {
		return "Contato{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", rg='" + rg + '\'' +
				", cpf='" + cpf + '\'' +
				", enderecos=" + enderecos +
				'}';
	}
}

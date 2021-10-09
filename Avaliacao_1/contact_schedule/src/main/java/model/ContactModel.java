package model;

import java.util.ArrayList;
import java.util.List;

public class ContactModel {
	
	private Integer id;
	private String name;
	private int rg;
	private int cpf;
	private List<AddressModel> addressList = new ArrayList<>();
	

	public ContactModel(Integer id, String name, int rg, int cpf, List<AddressModel> addressList) {
		super();
		this.id = id;
		this.name = name;
		this.rg = rg;
		this.cpf = cpf;
		this.addressList = addressList;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRg() {
		return rg;
	}


	public void setRg(int rg) {
		this.rg = rg;
	}


	public int getCpf() {
		return cpf;
	}


	public void setCpf(int cpf) {
		this.cpf = cpf;
	}



	public List<AddressModel> getAddressList() {
		return addressList;
	}



	public void setAddressList(List<AddressModel> addressList) {
		this.addressList = addressList;
	}


	
}

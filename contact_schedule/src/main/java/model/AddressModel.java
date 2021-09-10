package model;

public class AddressModel {
	private String street;
	private int number;
	private String complement;
	private String district;
	private String City;
	private String uf;
	
	
	public AddressModel(String street, int number, String complement, String district, String city, String uf) {
		super();
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		City = city;
		this.uf = uf;
	}
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}

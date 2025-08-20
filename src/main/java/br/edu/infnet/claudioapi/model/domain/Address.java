package br.edu.infnet.claudioapi.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String street;  	// rua
	private String number;  	// numero do estabelecimento
	private String zipcode;		// cep
	private String location;	// localizacao
	private String neighborhood;// bairro
	private String state;		// Estado
	private String uf;			// Unidade da Federacao
	private String complement;  // Complemento do Endereco
	
	   // TODO construtor Address
	
	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", street='" + street + '\'' +
				", number='" + number + '\'' +
				", zipcode='" + zipcode + '\'' +
				", location='" + location + '\'' +
				", neighborhood='" + neighborhood + '\'' +
				", state='" + state + '\'' +
				", uf='" + uf + '\'' +
				", complement='" + complement + '\'' +
				'}';
						
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getNeighborhood() {
		return neighborhood;
	}


	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}
 
}

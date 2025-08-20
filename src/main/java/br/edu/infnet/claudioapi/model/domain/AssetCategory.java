package br.edu.infnet.claudioapi.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssetCategory extends AssetRegistration{
		
	private String categoryName;    
    private int categoryCode;       
    private double taxRate;         
    private boolean active;        
    private String description;     
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
    private Address address;		
  
	@Override
	public String toString() {
		
		
		return String.format("AssetCategory{%s, categoryName=%s, categoryCode=%d, taxRate=%.2f, active=%s, description=%s, address=%s", 
				 super.toString(),categoryName, categoryCode, taxRate, active ? "ativo" : "inativo", description, address);
			
	}

	@Override
	public String obtainVisa() {
	
		return "AssetCategory";
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(int categoryCode) {
		this.categoryCode = categoryCode;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}

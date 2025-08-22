package br.edu.infnet.claudioapi.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class AssetCategory extends AssetRegistration{
		
	
	// RN08 - Nome da categoria
    @NotBlank(message = "Nome da categoria é obrigatório.")
    @Size(min = 3, max = 60, message = "Nome da categoria deve ter entre 3 e 60 caracteres.")
	private String categoryName;
	
    // RN09 - Código numérico único
    @NotNull(message = "Código da categoria é obrigatório.")
    @Min(value = 1, message = "Código da categoria deve ser positivo.")
    private int categoryCode;
    
    // RN10 - Alíquota
    @NotNull(message = "Taxa é obrigatória.")
    @DecimalMin(value = "0.0", inclusive = true, message = "Taxa deve ser maior 0%.")
    @DecimalMax(value = "100.0", inclusive = true, message = "Taxa deve ser menor 100%.")
    private double taxRate; 
    
    // RN07 + RN26 - Categoria ativa
    @NotNull(message = "Categoria deve estar ativa/inativa definida.")
    private boolean active; 
    
    // RN11 - Descrição (opcional, limite 255)
    @Size(max = 255, message = "Descrição da categoria não pode exceder 255 caracteres.")
    private String description;     
    
    
    // Associação com endereço
    @NotNull(message = "Endereço é obrigatório para categorias que exigem localização.")
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
    @Valid
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

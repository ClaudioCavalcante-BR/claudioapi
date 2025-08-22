package br.edu.infnet.claudioapi.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "asset_depreciations")
public class AssetDepreciation extends AssetRegistration {
	
	
	// RN21 — inteiro primitivo: não aceita null; valida limite com @Min
    @Column(nullable = false)
    @Min(value = 1, message = "Período de depreciação deve ser maior que zero.")
	private int depreciationPeriod;  // Periodo em anos
	
    
    // RN22 — double primitivo: não aceita null; validamos limites e finitude
    @Column(nullable = false)
    @PositiveOrZero(message = "Taxa de depreciação deve ser maior ou igual a 0.")
	private double depreciationRate; // Taxa (%)
	
    
    // RN23 — campo derivado; mantemos como primitivo e recalculamos no ciclo de vida
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // opcional, evita input no payload
	private boolean fullyDepreciated;  // Já depreciado?
    
    
    // Ex.: "08-2025" (MM-YYYY)
    @Column(length = 7)
    @NotBlank(message = "Mês de referência é obrigatório.")
    @Size(min = 7, max = 7, message = "Mês de referência deve estar no formato MM-YYYY.")
    @Pattern(
        regexp = "^(0[1-9]|1[0-2])-\\d{4}$",
        message = "Mês de referência inválido. Use o formato MM-YYYY (ex.: 08-2025)."
    )
    private String referenceMonth; // exemplo "2025-08"    
    
	
	@Override
	public String toString() {
	    return String.format("%s, Período: %d anos, Taxa: %.2f%%, %s, Ref: %s",
	            super.toString(), depreciationPeriod, depreciationRate,fullyDepreciated ? "Depreciado totalmente" : "Em depreciação",
	            referenceMonth);
	}
	
	@Override
	public String obtainVisa() {
		return "AssetDepreciation";
	}

	public int getDepreciationPeriod() {
		return depreciationPeriod;
	}

	public void setDepreciationPeriod(int depreciationPeriod) {
		this.depreciationPeriod = depreciationPeriod;
	}

	public double getDepreciationRate() {
		return depreciationRate;
	}

	public void setDepreciationRate(double depreciationRate) {
		this.depreciationRate = depreciationRate;
	}

	public boolean isFullyDepreciated() {
		return fullyDepreciated;
	}

	public void setFullyDepreciated(boolean fullyDepreciated) {
		this.fullyDepreciated = fullyDepreciated;
	}

	public String getReferenceMonth() {
		return referenceMonth;
	}

	public void setReferenceMonth(String referenceMonth) {
		this.referenceMonth = referenceMonth;
	}

}

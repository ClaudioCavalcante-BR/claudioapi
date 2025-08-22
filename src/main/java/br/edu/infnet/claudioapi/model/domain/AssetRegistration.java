package br.edu.infnet.claudioapi.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class AssetRegistration {     

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;					
	
	// RN01 - Nome obrigatório (3–120)
    @NotBlank(message = "Informe o nome do ativo (mín. 3 e máx. 120 caracteres).")
    @Size(min = 3, max = 120, message = "Nome do ativo deve ter entre 3 e 120 caracteres.")
	private String assetName;
	
    // RN02 - Ano de aquisição válido
    @NotBlank(message = "Ano de aquisição é obrigatório.")
    @Pattern(regexp = "^(19[0-9]{2}|20[0-9]{2})$", 
    message = "Ano de aquisição inválido. Use AAAA a partir de 1900.")
    private String acquisitionYear;
    
    // RN03 - Valor positivo
    @NotNull(message = "Informe o valor de aquisição.")
    @DecimalMin(value = "0.01", message = "Valor de aquisição deve ser maior que zero.")
	private String acquisitionValue;
	
    
    // RN04 + RN05 - Código único e formato (XXXXXXXX-XX)
    @NotBlank(message = "Código do ativo é obrigatório.")
    @Pattern(regexp = "^\\d{8}-[A-Z]{2}$",
             message = "Código do ativo inválido. Use o formato XXXXXXXX-XX (8 dígitos, hífen e 2 letras maiúsculas).")
    private String assetCode;         

   
	@Override
		public String toString() {
			return String.format("id=%d, assetName=%s, acquisitionYear=%s, acquisitionValue=%s, assetCode=%s",
					id, assetName, acquisitionYear, acquisitionValue, assetCode);
		}
	
	public abstract String obtainVisa();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAcquisitionYear() {
		return acquisitionYear;
	}

	public void setAcquisitionYear(String acquisitionYear) {
		this.acquisitionYear = acquisitionYear;
	}

	public String getAcquisitionValue() {
		return acquisitionValue;
	}

	public void setAcquisitionValue(String acquisitionValue) {
		this.acquisitionValue = acquisitionValue;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	} 

}

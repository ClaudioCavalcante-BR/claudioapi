package br.edu.infnet.claudioapi.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AssetRegistration {     // Cadastro de ativos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;					// Codigo do ativo
	
	private String assetName;         // Nome do ativo
	private String acquisitionYear;      // Ano de aquisição
	private String acquisitionValue;  // Valor de aquisição
	private String assetCode;         // Código interno do ativo "CHASSI ou SERIE"
	
	//TODO criacao construtor de AssetRegistration como assetName, acquisitionYear, acquisitionValue e assetCode
	
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

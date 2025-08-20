package br.edu.infnet.claudioapi.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AssetRegistration {     

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;					
	
	private String assetName;         
	private String acquisitionYear;     
	private String acquisitionValue;  
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

package br.edu.infnet.claudioapi.model.domain;

public class AssetDepreciation extends AssetRegistration {
	
	//private String assetId;            // ID do ativo
	private int depreciationPeriod;    // Período de depreciação em anos
	private double depreciationRate;   // Taxa de depreciação
	private boolean fullyDepreciated;  // Indica se o ativo já depreciou totalmente
	private String referenceMonth;     // Mês de referência do cálculo
    
	//TODO construtor do AssetDepreciation
	
	//TODO toString do AssetDepreciation
    
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

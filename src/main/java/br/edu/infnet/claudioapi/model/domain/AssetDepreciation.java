package br.edu.infnet.claudioapi.model.domain;

public class AssetDepreciation extends AssetRegistration {
		           
	private int depreciationPeriod;    
	private double depreciationRate;   
	private boolean fullyDepreciated;  
	private String referenceMonth;     
    
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

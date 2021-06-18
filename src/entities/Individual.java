package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;

	public Individual() {
		super();
	}

	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	public String toString() {
		return getName() + ": $ " + String.format("%.2f", tax());
	}

	@Override
	public Double tax() {
		if (getAnualIncome() < 20000) {
			if (healthExpenditures > 0) {
				return (getAnualIncome() * 0.15) - (healthExpenditures / 2);
			} else {
				return getAnualIncome() * 0.15;
			}
		} else {
			if (healthExpenditures > 0) {
				return (getAnualIncome() * 0.25) - (healthExpenditures / 2);
			} else {
				return getAnualIncome() * 0.25;
			}
		}
	}
}
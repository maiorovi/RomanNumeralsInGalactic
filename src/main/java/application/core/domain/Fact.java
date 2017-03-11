package application.core.domain;

public class Fact {
	private String entityName;
	private double decimalPrice;

	public Fact(String entityName, double decimalPrice) {
		this.entityName = entityName;
		this.decimalPrice = decimalPrice;
	}

	public String getEntityName() {
		return entityName;
	}

	public double getDecimalPrice() {
		return decimalPrice;
	}
}

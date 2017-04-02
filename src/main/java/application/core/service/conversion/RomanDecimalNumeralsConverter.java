package application.core.service.conversion;

import application.core.domain.enumeration.RomanNumeral;

public class RomanDecimalNumeralsConverter {

	public double toDecimal(String romanNumeral) {

		return RomanNumeral.convertToDecimal(romanNumeral);
	}

	public String toRomanNumeral(double decimalNumeral) {
		return "";
	}

}

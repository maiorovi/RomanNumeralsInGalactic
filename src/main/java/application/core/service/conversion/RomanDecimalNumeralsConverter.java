package application.core.service.conversion;

import application.core.domain.enumeration.RomanNumeral;
import one.util.streamex.StreamEx;

public class RomanDecimalNumeralsConverter {

	public double toDecimal(String romanNumeral) {
		double result = 0d;

		for (int i = 0; i < romanNumeral.length(); i++) {
			if (i + 1 != romanNumeral.length()) {
				RomanNumeral current = RomanNumeral.valueOf(String.valueOf(romanNumeral.charAt(i)));
				RomanNumeral next = RomanNumeral.valueOf(String.valueOf(romanNumeral.charAt(i + 1)));

				if (RomanNumeral.isGreater(next, current)) {
					result += next.minus(current);
					i++;
					continue;
				}
			}

			result += RomanNumeral.convertToDecimal(romanNumeral.charAt(i));
		}


		return result;
	}

	public String toRomanNumeral(double decimalNumeral) {
		return "";
	}


}

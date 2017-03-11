package application.core.domain.enumeration;

public enum RomanNumeral {
	I("I", 1),
	V("V", 5),
	X("X", 10),
	L("L", 50),
	C("C", 100),
	D("D", 500),
	M("M", 1000);


	private String romanNumeral;
	private Integer decimalDigit;

	RomanNumeral(String romanNumeral, Integer decimalDigit) {
		this.romanNumeral = romanNumeral;
		this.decimalDigit = decimalDigit;
	}

	public static double convertToDecimal(String romanNumber) {
		return 20;
	}

	public static String convertToNumeral(String numberal) {
		return "";
	}

}

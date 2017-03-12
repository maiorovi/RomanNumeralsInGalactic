package application.core.service.conversion;

import application.core.domain.GalaxyNumeral;
import application.core.domain.Mapping;

import java.util.List;

public class GalacticRomanNumeralConverter {

	private Mapping mapping;

	public GalacticRomanNumeralConverter(Mapping mapping) {
		this.mapping = mapping;
	}

	public String toRomanNumeral(List<String> number) {
		return "";
	}
}

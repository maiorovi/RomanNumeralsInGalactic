package application.core.domain;

import application.core.domain.enumeration.RomanNumeral;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

	private Map<String, RomanNumeral> galaxyToRomanNumerals;
	private Map<RomanNumeral, String> romanToGalaxyNumerals;

	public Mapping() {
		galaxyToRomanNumerals = new HashMap<>();
		romanToGalaxyNumerals = new HashMap<>();
	}

	public void add(String galaxyNumeral, RomanNumeral romanNumeral) {
		galaxyToRomanNumerals.put(galaxyNumeral, romanNumeral);
		romanToGalaxyNumerals.put(romanNumeral, galaxyNumeral);
	}

	public RomanNumeral convertToRomanNumeralFrom(String galaxyNumeral) {
		return galaxyToRomanNumerals.get(galaxyNumeral);
	}

	public String convertToGalaxyNumeralFrom(RomanNumeral romanNumeral) {
		return romanToGalaxyNumerals.get(romanNumeral);
	}

	public int size() {
		return galaxyToRomanNumerals.size();
	}
}

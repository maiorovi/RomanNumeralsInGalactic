package application.core.domain;

import application.core.domain.enumeration.RomanNumeral;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

	private Map<GalaxyNumeral, RomanNumeral> galaxyToRomanNumerals;
	private Map<RomanNumeral, GalaxyNumeral> romanToGalaxyNumerals;

	public Mapping() {
		galaxyToRomanNumerals = new HashMap<>();
		romanToGalaxyNumerals = new HashMap<>();
	}

	public void add(GalaxyNumeral galaxyNumeral, RomanNumeral romanNumeral) {
		galaxyToRomanNumerals.put(galaxyNumeral, romanNumeral);
		romanToGalaxyNumerals.put(romanNumeral, galaxyNumeral);
	}

	public RomanNumeral convertToRomanNumeralFrom(GalaxyNumeral galaxyNumeral) {
		return galaxyToRomanNumerals.get(galaxyNumeral);
	}

	public GalaxyNumeral convertToGalaxyNumeralFrom(RomanNumeral romanNumeral) {
		return romanToGalaxyNumerals.get(romanNumeral);
	}

	public int size() {
		return galaxyToRomanNumerals.size();
	}
}

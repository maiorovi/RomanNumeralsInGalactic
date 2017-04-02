package application.core.service.conversion;

import application.core.domain.Mapping;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.stream.Collectors;

public class GalacticRomanNumeralConverter {

	private Mapping mapping;

	public GalacticRomanNumeralConverter(Mapping mapping) {
		this.mapping = mapping;
	}

	public String toRomanNumeral(List<String> number) {
		Preconditions.checkArgument(number != null, "numbers cannot be null");
		Preconditions.checkArgument(number.stream().allMatch(item ->  item != null), "number can not contain null elements");

		return number.stream().map(numb -> mapping.convertToRomanNumeralFrom(numb)).map( romanNumeral -> romanNumeral.getRomanNumeral()).collect(Collectors.joining(""));
	}
}

package application.core.service.processing;

import application.core.domain.Fact;
import application.core.domain.Statement;
import application.core.domain.enumeration.RomanNumeral;
import application.core.service.conversion.GalacticRomanNumeralConverter;

import java.util.List;
import java.util.stream.Collectors;

public class StatementProcessingService {

	private GalacticRomanNumeralConverter galacticRomanNumeralConverter;

	public StatementProcessingService(GalacticRomanNumeralConverter galacticRomanNumeralConverter) {
		this.galacticRomanNumeralConverter = galacticRomanNumeralConverter;
	}

	public List<Fact> statementsProcessingService(List<Statement> statements) {
		return statements.stream().map(statement -> {
			double price = statement.getPrice();
			String amountInRomanNumber = galacticRomanNumeralConverter.toRomanNumeral(statement.getAmountInGalacticalNumbers());

			return new Fact(statement.getEntity(), price / RomanNumeral.convertToDecimal(amountInRomanNumber));
		}).collect(Collectors.toList());

	}
}

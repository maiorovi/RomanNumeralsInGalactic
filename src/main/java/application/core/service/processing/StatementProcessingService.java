package application.core.service.processing;

import application.core.domain.Fact;
import application.core.domain.Statement;
import application.core.domain.enumeration.RomanNumeral;
import application.core.service.conversion.GalacticRomanNumeralConverter;
import application.core.service.conversion.RomanDecimalNumeralsConverter;

import java.util.List;
import java.util.stream.Collectors;

public class StatementProcessingService {

	private GalacticRomanNumeralConverter galacticRomanNumeralConverter;
	private RomanDecimalNumeralsConverter romanDecimalNumeralsConverter;

	public StatementProcessingService(GalacticRomanNumeralConverter galacticRomanNumeralConverter, RomanDecimalNumeralsConverter romanDecimalNumeralsConverter) {
		this.galacticRomanNumeralConverter = galacticRomanNumeralConverter;
		this.romanDecimalNumeralsConverter = romanDecimalNumeralsConverter;
	}

	public List<Fact> statementsProcessingService(List<Statement> statements) {
		return statements.stream().map(statement -> {
			double price = statement.getPrice();
			String amountInRomanNumber = galacticRomanNumeralConverter.toRomanNumeral(statement.getAmountInGalacticalNumbers());

			return new Fact(statement.getEntity(), price / romanDecimalNumeralsConverter.toDecimal(amountInRomanNumber));
		}).collect(Collectors.toList());

	}

	public void setGalacticRomanNumeralConverter(GalacticRomanNumeralConverter galacticRomanNumeralConverter) {
		this.galacticRomanNumeralConverter = galacticRomanNumeralConverter;
	}
}

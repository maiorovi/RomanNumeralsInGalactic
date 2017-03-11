package application.core.service.processing;

import application.core.domain.Fact;
import application.core.domain.Statement;
import application.core.domain.enumeration.RomanNumeral;
import application.core.service.GalacticCurrencyConverter;

import java.util.List;
import java.util.stream.Collectors;

public class StatementProcessingService {

	private GalacticCurrencyConverter galacticCurrencyConverter;

	public StatementProcessingService(GalacticCurrencyConverter galacticCurrencyConverter) {
		this.galacticCurrencyConverter = galacticCurrencyConverter;
	}

	public List<Fact> statementsProcessingService(List<Statement> statements) {
		return statements.stream().map(statement -> {
			double price = statement.getPrice();
			String amountInRomanNumber = galacticCurrencyConverter.toRomanNumeral(statement.getAmountInGalacticalNumbers());

			return new Fact(statement.getEntity(), price / RomanNumeral.convertToDecimal(amountInRomanNumber));
		}).collect(Collectors.toList());

	}
}

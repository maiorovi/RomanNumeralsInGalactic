package application.core.service.processing;

import application.core.domain.Answer;
import application.core.domain.Fact;
import application.core.domain.Question;
import application.core.service.conversion.GalacticRomanNumeralConverter;
import application.core.service.conversion.RomanDecimalNumeralsConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuestionProcessingService {
	private GalacticRomanNumeralConverter galacticRomanNumeralConverter;
	private RomanDecimalNumeralsConverter romanDecimalNumeralsConverter;

	public QuestionProcessingService(GalacticRomanNumeralConverter galacticRomanNumeralConverter, RomanDecimalNumeralsConverter romanDecimalNumeralsConverter) {
		this.galacticRomanNumeralConverter = galacticRomanNumeralConverter;
		this.romanDecimalNumeralsConverter = romanDecimalNumeralsConverter;
	}

	public List<String> processQuestions(List<Question> questions, Map<String, Fact> entityToFactMapping) {
		List<String> answers = new ArrayList<>();

		for (Question question : questions) {
			String entity = question.getEntity().get();
			List<String> requestedAmount = question.getRequestedAmount();

			String romanNumeral = galacticRomanNumeralConverter.toRomanNumeral(requestedAmount);
			double decimalAmount = romanDecimalNumeralsConverter.toDecimal(romanNumeral);
			double price = entityToFactMapping.get(entity).getDecimalPrice() * decimalAmount;

			String answer = requestedAmount.stream().reduce("", (acc, x) -> acc + x +  " ") +  entity + " is "  + (int) price + " Credits";
			answers.add(answer);
		}

		return answers;
	}
}

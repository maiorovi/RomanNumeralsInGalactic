package application.core.service;

import application.core.domain.GalaxyNumeral;
import application.core.domain.Mapping;
import application.core.domain.Question;
import application.core.domain.Statement;
import application.core.domain.enumeration.RomanNumeral;
import application.core.dto.ProcessedTranslationRequest;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RequestMappingService {

	public ProcessedTranslationRequest process(List<String> lines) {
		ProcessedTranslationRequest processedRequest = new ProcessedTranslationRequest();

		Mapping mapping = new Mapping();
		List<Question> questions = new ArrayList<Question>();
		List<Statement> statements = new ArrayList<>();

		for (String line : lines) {
			if (isMapping(line)) {
				String parts[] = line.split("\\s");
				String galaxyNumeral = parts[0];
				RomanNumeral romanNumeral = RomanNumeral.valueOf(parts[2]);

				mapping.add(galaxyNumeral, romanNumeral);
			} else if (isQuestion(line)) {
				questions.add(new Question(line));
			} else {
				statements.add(new Statement(line));
			}
		}

		processedRequest.setMapping(mapping);
		processedRequest.setQuestion(questions);
		processedRequest.setStatements(statements);

		return processedRequest;
	}

	private boolean isMapping(String line) {
		List<String> romanIdentifierContainer = Lists.newArrayList("I", "V", "X", "L", "M");

		Predicate<String> isRomanNumeralMapping = ch -> line.split("\\s")[2].equals(ch);

		return romanIdentifierContainer.stream().map(ch -> isRomanNumeralMapping.test(ch)).reduce(false, (op1, op2) -> op1 || op2);
	}

	private boolean isQuestion(String line) {
		return line.contains("?") && line.charAt(line.length() - 1) == '?';
	}
}

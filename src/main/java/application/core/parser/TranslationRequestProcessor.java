package application.core.parser;

import application.core.domain.GalaxyNumeral;
import application.core.domain.Mapping;
import application.core.domain.enumeration.RomanNumeral;
import application.core.dto.ProcessedTranslationRequest;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;

public class TranslationRequestProcessor {



	public ProcessedTranslationRequest process(List<String> lines) {
		ProcessedTranslationRequest processedRequest = new ProcessedTranslationRequest();

		Mapping mapping = new Mapping();

		for(String line : lines) {
			if (isMapping(line)) {
				String parts[] = line.split("\\s");
				GalaxyNumeral galaxyNumeral = new GalaxyNumeral(parts[0]);
				RomanNumeral romanNumeral = RomanNumeral.valueOf(parts[2]);

				mapping.add(galaxyNumeral, romanNumeral);
			}
		}

		processedRequest.setMapping(mapping);

		return processedRequest;
	}

	private boolean isMapping(String line) {
		List<String> romanIdentifierContainer = Lists.newArrayList("I", "V", "X", "L", "M");

		Predicate<String> isRomanNumeralMapping = ch -> line.split("\\s")[2].equals(ch);

		return romanIdentifierContainer.stream().map(ch -> isRomanNumeralMapping.test(ch)).reduce(false, (op1, op2) -> op1 || op2);
	}



}

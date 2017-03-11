package application.core.parser;

import application.core.domain.GalaxyNumeral;
import application.core.domain.Mapping;
import application.core.domain.enumeration.RomanNumeral;
import application.core.dto.ProcessedTranslationRequest;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;

public class TranslationRequestProcessor {


	public ProcessedTranslationRequest process(List<String> lines) {
		ProcessedTranslationRequest processedRequest = new ProcessedTranslationRequest();
		//refactor this piece of code. collector can works incorrectly in parallel environment
		Mapping mapping = lines.stream()
				.filter(this::isMapping)
				.collect(Collector.of(Mapping::new, (map, line) -> {
					String[] parts = line.split("\\s");
					map.add(new GalaxyNumeral(parts[0]), RomanNumeral.valueOf(parts[2]));
				}, (m1, m2) -> m1));

		processedRequest.setMapping(mapping);

		return processedRequest;
	}

	private boolean isMapping(String line) {
		List<String> romanIdentifierContainer = Lists.newArrayList("I", "V", "X", "L", "M");

		Predicate<String> isRomanNumeralMapping = ch -> line.split("\\s")[2].equals(ch);

		return romanIdentifierContainer.stream().map(ch -> isRomanNumeralMapping.test(ch)).reduce(false, (op1, op2) -> op1 || op2);
	}


}

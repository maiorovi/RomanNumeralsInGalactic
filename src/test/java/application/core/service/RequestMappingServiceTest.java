package application.core.service;

import application.core.dto.ProcessedTranslationRequest;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestMappingServiceTest {

	RequestMappingService parser = new RequestMappingService();

	@Test
	public void parsesLineWithRomanNumeralOneAsAMapping() {
		List<String> mappings = Lists.newArrayList("glob is I");

		ProcessedTranslationRequest translationRequestProcessor = parser.process(mappings);

		assertThat(translationRequestProcessor.getMappings().size()).isEqualTo(1);
	}

	@Test
	public void parsesLineWithRomanNumeralFiveAsMapping() throws Exception {
		List<String> mappings = Lists.newArrayList("prok is V");

		ProcessedTranslationRequest translationRequestProcessor = parser.process(mappings);

		assertThat(translationRequestProcessor.getMappings().size()).isEqualTo(1);
	}

	@Test
	public void parsesLineWithRomanNumeralTenAsMapping() throws Exception {
		List<String> mappings = Lists.newArrayList("pishi is X");

		ProcessedTranslationRequest translationRequestProcessor = parser.process(mappings);

		assertThat(translationRequestProcessor.getMappings().size()).isEqualTo(1);
	}

	@Test
	public void parsesLineWIthRomaNumeralOneHundreadAsMapping() throws Exception {
		List<String> mappings = Lists.newArrayList("tegj is L");

		ProcessedTranslationRequest translationRequestProcessor = parser.process(mappings);

		assertThat(translationRequestProcessor.getMappings().size()).isEqualTo(1);
	}

	@Test
	public void parsesLineWIthRomaNumeralOneThousanddAsMapping() throws Exception {
		List<String> mappings = Lists.newArrayList("prek is M");

		ProcessedTranslationRequest translationRequestProcessor = parser.process(mappings);

		assertThat(translationRequestProcessor.getMappings().size()).isEqualTo(1);
	}

	@Test
	public void notParsesWhichContainsRomanNumeralsJustAccidently() throws Exception {
		List<String> mappings = Lists.newArrayList("prek is Money");

		ProcessedTranslationRequest translationRequestProcessor = parser.process(mappings);

		assertThat(translationRequestProcessor.getMappings().size()).isEqualTo(0);
	}

	@Test
	public void parsesRowsWithQuestionMarkInTheEndAsQuestions() throws Exception {
		List<String> mappings = Lists.newArrayList("how many Credits is glob prok Silver ?");

		ProcessedTranslationRequest translationRequest = parser.process(mappings);

		assertThat(translationRequest.getQuestions().size()).isEqualTo(1);
	}
}

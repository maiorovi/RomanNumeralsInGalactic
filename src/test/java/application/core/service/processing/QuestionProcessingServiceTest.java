package application.core.service.processing;

import application.core.domain.Answer;
import application.core.domain.Fact;
import application.core.domain.Question;
import application.core.service.conversion.GalacticRomanNumeralConverter;
import application.core.service.conversion.RomanDecimalNumeralsConverter;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionProcessingServiceTest {
	private QuestionProcessingService questionProcessingService;
	private GalacticRomanNumeralConverter galacticRomanNumeralConverter;
	private RomanDecimalNumeralsConverter romanDecimalNumeralsConverter;
	private Map<String, Fact> entityToFactMapping;
	private List<Question> questions;
	private Question question;

	@Before
	public void setUp() throws Exception {
		galacticRomanNumeralConverter = mock(GalacticRomanNumeralConverter.class);
		romanDecimalNumeralsConverter = mock(RomanDecimalNumeralsConverter.class);
		entityToFactMapping = mock(Map.class);

		questionProcessingService = new QuestionProcessingService(galacticRomanNumeralConverter, romanDecimalNumeralsConverter, entityToFactMapping);
		question = mock(Question.class);

		//TODO: use mock of list
		questions = new ArrayList<>();
	}

	@Test
	public void answersSimpleQuestionAboutSilver() throws Exception {
		List<String> galacticNumber = Lists.newArrayList("glob", "prok");
		questions.add(question);
		when(question.getEntity()).thenReturn(Optional.of("Silver"));
		when(question.getRequestedAmount()).thenReturn(galacticNumber);

		when(galacticRomanNumeralConverter.toRomanNumeral(galacticNumber)).thenReturn("IV");
		when(romanDecimalNumeralsConverter.toDecimal("IV")).thenReturn(4.0);
		when(entityToFactMapping.get("Silver")).thenReturn(new Fact("Silver", 17));

		List<String> answers  = questionProcessingService.processQuestions(questions);

		assertThat(answers.size()).isEqualTo(1);
		assertThat(answers.get(0)).isEqualTo("glob prok Silver is 68 Credits");
	}


}

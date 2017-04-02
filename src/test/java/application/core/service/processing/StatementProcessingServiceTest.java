package application.core.service.processing;

import application.core.domain.Fact;
import application.core.domain.Statement;
import application.core.service.conversion.GalacticRomanNumeralConverter;
import application.core.service.conversion.RomanDecimalNumeralsConverter;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatementProcessingServiceTest {

	private StatementProcessingService processingService;
	private Statement statement;
	private GalacticRomanNumeralConverter galacticRomanNumeralConverter;
	private RomanDecimalNumeralsConverter romanDecimalNumeralsConverter;

	@Before
	public void setUp() throws Exception {
		statement = mock(Statement.class);
		galacticRomanNumeralConverter = mock(GalacticRomanNumeralConverter.class);
		romanDecimalNumeralsConverter = mock(RomanDecimalNumeralsConverter.class);
		processingService = new StatementProcessingService(galacticRomanNumeralConverter, romanDecimalNumeralsConverter);
	}

	@Test
	public void processAStatement() throws Exception {
		when(statement.getAmountInGalacticalNumbers()).thenReturn(Lists.newArrayList("pish", "pish"));
		when(statement.getEntity()).thenReturn("Iron");
		when(statement.getPrice()).thenReturn(3910d);
		when(galacticRomanNumeralConverter.toRomanNumeral(any(List.class))).thenReturn("XX");
		when(romanDecimalNumeralsConverter.toDecimal("XX")).thenReturn(20d);

		List<Fact> facts = processingService.statementsProcessingService(Lists.newArrayList(statement));

		assertThat(facts.size()).isEqualTo(1);
		assertThat(facts)
				.extracting("entityName")
				.containsExactly("Iron");
		assertThat(facts)
				.extracting("decimalPrice")
				.containsExactly(195.5);
	}


}

package application.core.service.conversion;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanDecimalNumeralsConverterTest {
	private RomanDecimalNumeralsConverter romanDecimalNumeralsConverter;

	@Before
	public void setUp() throws Exception {
		romanDecimalNumeralsConverter = new RomanDecimalNumeralsConverter();
	}

	@Test
	public void convertsIToOne() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("I")).isEqualTo(1d);
	}

	@Test
	public void convertsVToFive() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("V")).isEqualTo(5d);
	}

	@Test
	public void convertsXToTen() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("X")).isEqualTo(10d);
	}
}

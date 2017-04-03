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

	@Test
	public void convertsLToFifty() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("L")).isEqualTo(50d);
	}

	@Test
	public void convertsCToOneHundread() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("C")).isEqualTo(100d);
	}

	@Test
	public void convertsMToOneThousand() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("M")).isEqualTo(1000d);
	}

	@Test
	public void allNumbersAreAddedToFormResult() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("LXX")).isEqualTo(70);
	}

	@Test
	public void allNumbersAreAddedToFormResultMCC() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("MCC")).isEqualTo(1200);
	}

	@Test
	public void IVRomanNumeralIsEqualTo4() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("IV")).isEqualTo(4);
	}

	@Test
	public void XCIXIsEqualTo99() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("XCIX")).isEqualTo(99);
	}

	@Test
	public void XCVIsEqualToXCV() throws Exception {
		assertThat(romanDecimalNumeralsConverter.toDecimal("XCV")).isEqualTo(95);
	}
}

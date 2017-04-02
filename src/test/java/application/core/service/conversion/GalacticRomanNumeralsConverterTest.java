package application.core.service.conversion;

import application.core.domain.GalaxyNumeral;
import application.core.domain.Mapping;
import application.core.domain.enumeration.RomanNumeral;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GalacticRomanNumeralsConverterTest {

	private GalacticRomanNumeralConverter converter;
	private Mapping mapping;

	@Before
	public void setUp() throws Exception {
		mapping = mock(Mapping.class);
		when(mapping.convertToRomanNumeralFrom("glob")).thenReturn(RomanNumeral.I);
		when(mapping.convertToRomanNumeralFrom("prok")).thenReturn(RomanNumeral.V);

		converter = new GalacticRomanNumeralConverter(mapping);
	}

	@Test
	public void producesRomanNumeralAsAString() throws Exception {


		String romanNumeral = converter.toRomanNumeral(Lists.newArrayList("glob", "prok"));

		assertThat(romanNumeral).isEqualTo("IV");
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsIllegalArgumentExceptionOnNullArgument() throws Exception {
		converter.toRomanNumeral(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsIllegalArgumentExceptionIfOneOfListMembersIsNull() throws Exception {
		converter.toRomanNumeral(Lists.newArrayList("glob", null, "prok"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void throwsIllegalArgumentExceptionWhenInvalidStringPassedForConversion() throws Exception {
		converter.toRomanNumeral(Lists.newArrayList("glob", "prok", "abc"));
	}
}

package application.core.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StatementTest {

	private Statement statement;

	@Before
	public void setUp() throws Exception {
		statement = new Statement("pish pish Iron is 3910 Credits");
	}

	@Test
	public void returnsGalacticNumeralsFromStatementAsList() throws Exception {
		List<String> numbers = statement.getAmountInGalacticalNumbers();

		assertThat(numbers).containsExactly("pish", "pish");
	}

	@Test
	public void returnsGalacticNumerals() throws Exception {
		statement = new Statement("glob prok Gold is 57800 Credits");

		List<String> numbers = statement.getAmountInGalacticalNumbers();

		assertThat(numbers).containsExactly("glob", "prok");
	}

	@Test
	public void processesAreAsASplitingWord() throws Exception {
		statement = new Statement("glob glob pants are 57800 Credits");

		List<String> numbers = statement.getAmountInGalacticalNumbers();

		assertThat(numbers).containsExactly("glob", "glob");
	}

	@Test
	public void identifiesLowerCasedEntityBasedOnPositionOfSplittingKeyword() throws Exception {
		statement = new Statement("glob glob Pants are 57800 Credits");

		String entityName = statement.getEntity();

		assertThat(entityName).isEqualTo("pants");
	}

	@Test
	public void pricesThePricesOfOneItemFromAStatement() throws Exception {
		statement = new Statement("glob glob Pants are 57800 Credits");

		double price = statement.getPrice();

		assertThat(price).isEqualTo(57800);
	}
}

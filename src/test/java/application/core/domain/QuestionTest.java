package application.core.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionTest {
	private Question question;

	@Before
	public void setUp() throws Exception {
		question = new Question("how many Credits is glob prok Silver ?");
	}

	@Test
	public void identifiesEntityInQuestion() throws Exception {
		String entity = question.getEntity().get();

		assertThat(entity).isEqualTo("silver");
	}

	@Test
	public void identifiesGalaxyNumberInQuestion() throws Exception {
		List<String> numbers = question.getRequestedAmount();

		assertThat(numbers).containsExactly("glob", "prok");
	}
}

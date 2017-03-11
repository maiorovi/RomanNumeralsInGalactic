package application.core.service.processing;

import org.junit.Before;
import org.junit.Test;

public class StatementProcessingServiceTest {

	StatementProcessingService processingService;

	@Before
	public void setUp() throws Exception {
		processingService = new StatementProcessingService();
	}

	@Test
	public void processAStatement() throws Exception {
		String statement = "pish pish Iron is 3910 Credits";

	}
}

package integration;

import application.config.RomanNumeralsInGalacticCoreConfiguration;
import application.core.readers.FileDataReader;
import application.core.service.ConvertionEngineFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RomanNumeralsInGalacticCoreConfiguration.class)
public class RomanNumeralsInGalacticIntegrationTest {

	@Autowired
	private ConvertionEngineFacade convertionEngineFacade;
	@Autowired
	private FileDataReader fileDataReader;

	@Test
	public void scenario1() throws Exception {
		List<String> lines = fileDataReader.reader("data.txt");
		List<String> response = convertionEngineFacade.process(lines);
		response.forEach(System.out::println);
	}
}

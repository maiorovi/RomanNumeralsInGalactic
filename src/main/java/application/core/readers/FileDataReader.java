package application.core.readers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader<String, String> {
	@Override
	public List<String> reader(String source) {
		List<String> lines = null;

		try {
			lines = Files.readAllLines(Paths.get(this.getClass().getClassLoader().getResource(source).toURI()), Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return lines;
	}
}

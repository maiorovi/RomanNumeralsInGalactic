package application.core.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Note: supports only questions with entity
public class Question {
	private String question;
	private String[] questionParts;
	private Integer isPosition;

	public Question(String question) {
		this.question = question;
		questionParts = question.split("\\s");
		isPosition = IntStream.range(0, questionParts.length).filter(index -> questionParts[index].toLowerCase().equals("is")).findFirst().getAsInt();
	}

	public Optional<String> getEntity() {
		return Optional.of(questionParts[questionParts.length - 2].toLowerCase());
	}

	public List<String> getRequestedAmount() {
		return IntStream.range(isPosition + 1, questionParts.length - 2).mapToObj( index -> questionParts[index]).collect(Collectors.toList());
	}
}

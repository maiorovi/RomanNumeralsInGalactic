package application.core.domain;

public class Answer {

	String answer;

	public Answer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return answer;
	}
}

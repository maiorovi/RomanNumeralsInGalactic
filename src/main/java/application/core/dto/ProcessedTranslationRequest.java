package application.core.dto;

import application.core.domain.Mapping;
import application.core.domain.Question;
import application.core.domain.Statement;

import java.util.List;

public class ProcessedTranslationRequest {
	private List<Question> questions;
	private Mapping mapping;
	private List<Statement> statements;

	public Mapping getMappings() {
		return mapping;
	}

	public void setMapping(Mapping mapping) {
		this.mapping = mapping;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestion(List<Question> questions) {
		this.questions = questions;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public List<Statement> getStatements() {
		return statements;
	}
}

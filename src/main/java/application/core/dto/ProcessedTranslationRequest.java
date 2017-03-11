package application.core.dto;

import application.core.domain.Mapping;
import application.core.domain.Question;

import java.sql.Statement;
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
}

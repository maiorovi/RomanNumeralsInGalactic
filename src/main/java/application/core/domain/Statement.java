package application.core.domain;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Statement {
	private String stringifiedStatement;
	private List<String> galacticNumbers;
	private Integer isPosition;
	private String[] statementParts;

	//TODO: add validation to statement constructor
	public Statement(String statement) {
		this.stringifiedStatement = statement;
		statementParts = statement.split("\\s");
		isPosition = IntStream.range(0, statementParts.length - 1).filter(index -> statementParts[index].equals("is") || statementParts[index].equals("are")).findFirst().getAsInt();
	}

	public List<String> getAmountInGalacticalNumbers() {
		if (galacticNumbers != null) {
			return galacticNumbers;
		}

		galacticNumbers = IntStream.range(0, isPosition - 1).mapToObj(index -> statementParts[index]).collect(Collectors.toList());

		return galacticNumbers;
	}

	public String getEntity() {
		return statementParts[isPosition - 1].toLowerCase();
	}

	public double getPrice() {
		return Double.parseDouble(statementParts[isPosition+1]);
	}
}

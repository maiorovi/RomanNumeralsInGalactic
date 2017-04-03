package application.core.service;

import application.core.domain.Answer;
import application.core.domain.Fact;
import application.core.dto.ProcessedTranslationRequest;
import application.core.service.conversion.GalacticRomanNumeralConverter;
import application.core.service.processing.QuestionProcessingService;
import application.core.service.processing.StatementProcessingService;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertionEngineFacade {
	private RequestMappingService requestMappingService;
	private QuestionProcessingService questionProcessingService;
	private StatementProcessingService statementProcessingService;

	public ConvertionEngineFacade(RequestMappingService requestMappingService, QuestionProcessingService questionProcessingService, StatementProcessingService statementProcessingService) {
		this.requestMappingService = requestMappingService;
		this.questionProcessingService = questionProcessingService;
		this.statementProcessingService = statementProcessingService;
	}

	public List<String> process(List<String> lines) {
		ProcessedTranslationRequest  processedTranslationRequest = requestMappingService.process(lines);
//		GalacticRomanNumeralConverter galacticRomanNumeralConverter = new GalacticRomanNumeralConverter(processedTranslationRequest.getMapping());
		//need to inject fact to question processing service
		List<Fact> facts = statementProcessingService.statementsProcessingService(processedTranslationRequest.getStatements());

		return questionProcessingService.processQuestions(processedTranslationRequest.getQuestions(),
				facts.stream().collect(Collectors.toMap(Fact::getEntityName, Function.identity())));
	}
}

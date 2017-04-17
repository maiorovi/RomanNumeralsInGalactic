package application.config;

import application.core.domain.Mapping;
import application.core.readers.FileDataReader;
import application.core.service.ConvertionEngineFacade;
import application.core.service.RequestMappingService;
import application.core.service.conversion.GalacticRomanNumeralConverter;
import application.core.service.conversion.RomanDecimalNumeralsConverter;
import application.core.service.processing.QuestionProcessingService;
import application.core.service.processing.StatementProcessingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RomanNumeralsInGalacticCoreConfiguration {

	@Bean
	public ConvertionEngineFacade convertionEngineFacade(RequestMappingService requestMappingService,
	                                                     QuestionProcessingService questionProcessingService,
	                                                     StatementProcessingService statementProcessingService
	                                                     ) {

		return new ConvertionEngineFacade(requestMappingService, questionProcessingService, statementProcessingService);
	}

	@Bean
	public FileDataReader fileDataReader() {
		return new FileDataReader();
	}

	@Bean
	public RequestMappingService requestMappingService() {
		return new RequestMappingService();
	}

	@Bean
	public QuestionProcessingService questionProcessingService(GalacticRomanNumeralConverter galacticRomanNumeralConverter,
	                                                           RomanDecimalNumeralsConverter romanDecimalNumeralsConverter) {
		//todo what is entity to fact mapping
		return new QuestionProcessingService(galacticRomanNumeralConverter,
												romanDecimalNumeralsConverter);
	}

	@Bean
	public StatementProcessingService statementProcessingService(GalacticRomanNumeralConverter galacticRomanNumeralConverter,
	                                                             RomanDecimalNumeralsConverter romanDecimalNumeralsConverter) {
		return new StatementProcessingService(galacticRomanNumeralConverter, romanDecimalNumeralsConverter);
	}

	@Bean
	public GalacticRomanNumeralConverter galacticRomanNumeralConverter() {
		//tODO: mapping builder required
		return  new GalacticRomanNumeralConverter(null);
	}

	@Bean
	public RomanDecimalNumeralsConverter romanDecimalNumeralsConverter() {
		return new RomanDecimalNumeralsConverter();
	}
}

package pe.com.bootcamp.configurations;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket swaggerPersonApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Person")
				.select()
				.apis(RequestHandlerSelectors.basePackage("pe.com.bootcamp.controllers"))
		        .paths(regex("/affiliate.*"))		        
		        .build()		        
		        .enableUrlTemplating(true)
		        .apiInfo(apiEndPointsInfo())
		        .securitySchemes(Arrays.asList(apiKey()));
	}	
	
	@Bean
    public Docket swaggerAffiliateApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Affiliate")
                .select()
				.apis(RequestHandlerSelectors.basePackage("pe.com.bootcamp.controllers"))		        
		        .paths(regex("/person.*"))
		        .build()		        
		        .enableUrlTemplating(true)
		        .apiInfo(apiEndPointsInfo())
		        .securitySchemes(Arrays.asList(apiKey()));
    }	
	
	@Bean
    public Docket swaggerContributionApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Contribution")
                .select()
				.apis(RequestHandlerSelectors.basePackage("pe.com.bootcamp.controllers"))		        
		        .paths(regex("/contribution.*"))
		        .build()		        
		        .enableUrlTemplating(true)
		        .apiInfo(apiEndPointsInfo())
		        .securitySchemes(Arrays.asList(apiKey()));
    }	
	
	private ApiInfo apiEndPointsInfo() {

	    return new ApiInfoBuilder()
	            .title("Bootcamp Java")
	            .description("demo AFP")
	            .version("1.0")
	            .build();
	} 
	
	private ApiKey apiKey() {
		return new ApiKey("apiKey", "Authorization", "header");
	}
}

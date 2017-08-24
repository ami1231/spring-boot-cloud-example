package lotteryaward.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false) //隱藏API列表上的 response message 代碼解釋
                .select()
                .apis(RequestHandlerSelectors.basePackage("lotteryaward.member.controller")) //controller 目錄
                .paths(PathSelectors.any())
                .build();
    }
	  
	
	  
	 private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("member-api")
                .version("1.0")
                .build();
	   }

}

package ru.storage.project.config;


import io.swagger.models.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.time.LocalDate;

@Configuration
@EnableSwagger2WebMvc
public class SpringFoxConfig {


    @Bean
    public Docket swaggerSpringfoxDocket() {
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .paths(PathSelectors.any())
                .build().directModelSubstitute(LocalDate.class,String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }

    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo metaInfo() {
        return new ApiInfo(
                "Storage modul API",
                "Хранение данных о книгах и авторах",
                "1.0",
                "Terms of Service",
                "Corp",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/"
        );
    }
}

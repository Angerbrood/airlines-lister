package edu.elte.airlines.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import edu.elte.airlines.configuration.service.ServiceConfig;
import edu.elte.airlines.configuration.spring.SecurityConfig;
import edu.elte.airlines.configuration.spring.ThymeleafConfig;

@Configuration
@Import({ServiceConfig.class, SecurityConfig.class, ThymeleafConfig.class})
@ComponentScan(basePackages = {"edu.elte.airlines.domain", "edu.elte.airlines.dto", "edu.elte.airlines"})
public class ApplicationConfig {
    @Bean
    ConversionService conversionService() {
        return new DefaultConversionService();
    }
    @Bean
    ConverterRegister converterRegister() {
        return new ConverterRegister();
    }
}

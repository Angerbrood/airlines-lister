package edu.elte.airlines.configuration;

import edu.elte.airlines.converter.AirlineDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan("edu.elte.airlines.converter")
@Import({DispatcherConfig.class, ServiceConfig.class, ConverterConfig.class})
public class ApplicationConfig {
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10000);
        return new CommonsMultipartResolver();
    }

}

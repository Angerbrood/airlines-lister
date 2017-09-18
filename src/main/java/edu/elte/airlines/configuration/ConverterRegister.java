package edu.elte.airlines.configuration;

import java.util.Collection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class ConverterRegister extends WebMvcConfigurerAdapter
implements ApplicationListener<ApplicationEvent>, ApplicationContextAware {
    @Autowired
    private DefaultConversionService service;
    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            Collection<Converter> converters = applicationContext.getBeansOfType(Converter.class).values();
            converters.stream().forEach((converter -> service.addConverter(converter)));
        }
    }
}

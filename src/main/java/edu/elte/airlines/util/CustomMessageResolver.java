package edu.elte.airlines.util;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.messageresolver.IMessageResolver;

@Component
public class CustomMessageResolver implements IMessageResolver {
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public Integer getOrder() {
        return 1;
    }

    @Override
    public String resolveMessage(ITemplateContext iTemplateContext, Class<?> aClass, String s, Object[] objects) {
        System.out.println("Message resolver invoked");
        return "resolved";
    }

    @Override
    public String createAbsentMessageRepresentation(ITemplateContext iTemplateContext, Class<?> aClass, String s, Object[] objects) {
        return null;
    }
}

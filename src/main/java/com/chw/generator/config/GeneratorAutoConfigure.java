package com.chw.generator.config;

import com.chw.generator.context.GeneratorTemplate;
import com.chw.generator.context.GeneratorTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(GeneratorTemplate.class)
@EnableConfigurationProperties(TemplateProperties.class)
public  class GeneratorAutoConfigure {

    @Autowired
    private TemplateProperties templateProperties;
    @Bean
    @ConditionalOnMissingBean
    GeneratorTemplate generatorTemplate(){
        return GeneratorTemplateFactory.CreateGeneratorTemplate(templateProperties);
    }
}

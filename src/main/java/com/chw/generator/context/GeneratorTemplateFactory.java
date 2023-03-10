package com.chw.generator.context;

import com.chw.generator.annotation.EngineType;
import com.chw.generator.config.TemplateProperties;
import com.chw.generator.domain.ProduceModel;
import com.chw.generator.domain.ProductFrontendModel;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;


/**
 * @author chw
 */
public final class GeneratorTemplateFactory implements BeanFactoryAware {

    private static  final String defaultEngineType="freeMaker";
    private static DefaultListableBeanFactory beanFactory;
    public static GeneratorTemplate CreateGeneratorTemplate (TemplateProperties templateProperties){
        if(templateProperties==null)  return null;
        String engineType=templateProperties.getEngineType();
        if (engineType.equals(defaultEngineType)||engineType==null) return new DefaultGeneratorTemplate(templateProperties, new ProductFrontendModel());
        else  {
           Map<String,BaseGeneratorTemplate> generatorTemplateMap= beanFactory.getBeansOfType(BaseGeneratorTemplate.class);
            AtomicReference<BaseGeneratorTemplate> template = null;
           generatorTemplateMap.forEach((k,v)->{
               EngineType type= AnnotationUtils.findAnnotation(v.getClass(), EngineType.class);
               if(type!=null&&type.value().equals(engineType)){
                   template.set(v);
                   return;
               }
           });
            Map<String, ProduceModel> produceModelMap= beanFactory.getBeansOfType(ProduceModel.class);
            AtomicReference<ProduceModel> produceModel = null;
            produceModelMap.forEach((k,v)->{
                EngineType type= AnnotationUtils.findAnnotation(v.getClass(), EngineType.class);
                if(type!=null&&type.value().equals(engineType)){
                    produceModel.set(v);
                    return;
                }
            });
            BaseGeneratorTemplate baseGeneratorTemplate= template.get();
            baseGeneratorTemplate.setTemplateProperties(templateProperties);
            baseGeneratorTemplate.setProduceModel(produceModel.get());
           return baseGeneratorTemplate;
        }

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        GeneratorTemplateFactory.beanFactory =(DefaultListableBeanFactory)beanFactory;
    }
}

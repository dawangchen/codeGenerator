package com.chw.generator.context;

import com.chw.generator.config.TemplateProperties;
import com.chw.generator.domain.ProduceModel;

/**
 * @author chw
 */
public abstract class BaseGeneratorTemplate implements GeneratorTemplate{
    protected TemplateProperties templateProperties;
    protected ProduceModel produceModel;

    public TemplateProperties getTemplateProperties() {
        return templateProperties;
    }

    public void setTemplateProperties(TemplateProperties templateProperties) {
        this.templateProperties = templateProperties;
    }

    public ProduceModel getProduceModel() {
        return produceModel;
    }

    public void setProduceModel(ProduceModel produceModel) {
        this.produceModel = produceModel;
    }

    public BaseGeneratorTemplate(TemplateProperties templateProperties, ProduceModel produceModel){
        this.templateProperties=templateProperties;
        this.produceModel=produceModel;
        this.initTemplateEngine();
    }
    /**
     * 生成目标模板
     *
     * @param templateName 模板名称
     * @param filePath     文件路径
     * @param fileName     文件名
     * @param dataModel    模板数据模型
     */
    @Override
    public void generate(String templateName, String filePath, String fileName, Class dataModel) {
      process(templateName, filePath, fileName, dataModel);
    }

    /**
     *  初始化模板引擎
     */
    protected abstract  void initTemplateEngine();
    protected abstract  void  process(String templateName, String filePath, String fileName, Class dataModel);
}

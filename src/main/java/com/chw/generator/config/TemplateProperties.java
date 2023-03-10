package com.chw.generator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chw
 */
@ConfigurationProperties(prefix = "generator.template")
public class TemplateProperties {
    //模板路径
    private String templatePath;
    //模板输出路径
    private String outPutPath;
    //模板引擎类型
    private String engineType;

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getOutPutPath() {
        return outPutPath;
    }

    public void setOutPutPath(String outPutPath) {
        this.outPutPath = outPutPath;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}

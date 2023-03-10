package com.chw.generator.context;

import com.chw.generator.annotation.EngineType;
import com.chw.generator.config.TemplateProperties;
import com.chw.generator.domain.ProduceModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author chw
 */
@EngineType(value = "freeMaker")
public final class DefaultGeneratorTemplate extends BaseGeneratorTemplate{
    private Configuration freeMarker;
    private final String templatePath="template";
    public DefaultGeneratorTemplate(TemplateProperties templateProperties, ProduceModel produceModel) {
        super(templateProperties, produceModel);
    }

    /**
     * 初始化模板引擎
     */
    @Override
    protected void initTemplateEngine() {
        Configuration cfg = new Configuration();
        File templateFile;
        try {
            if(!StringUtils.isEmpty(this.templateProperties.getTemplatePath())){
                templateFile= ResourceUtils.getFile("classPath:"+this.templateProperties.getTemplatePath());
            }else {
                templateFile=ResourceUtils.getFile("classPath:"+this.templatePath);
            }
            cfg.setDirectoryForTemplateLoading(templateFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        this.freeMarker=cfg;
    }

    @Override
    protected void process(String templateName, String filePath, String fileName, Class dataModel) {
        Template template = null;
        try {
            template = freeMarker.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(filePath, fileName );
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            template.process(dataModel,  out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

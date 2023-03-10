package com.chw.generator.context;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author chw
 */
public interface GeneratorTemplate {
    /**
     *  生成目标模板
     * @param templateName 模板名称
     * @param filePath  文件路径
     * @param fileName 文件名
     * @param dataModel  模板数据模型
     */
    void generate(String templateName,String filePath, String fileName,Class dataModel);
}

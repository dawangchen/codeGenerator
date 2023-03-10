package com.chw.generator.domain;

/**
 *  生产模型对象
 * @author chw
 */
public interface ProduceModel<R> {
    R ProduceModel(Class model) throws Exception;
}

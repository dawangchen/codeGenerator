package com.chw.generator.model;

import java.util.List;

/**
 * @author chw
 */
public class TableModel {
    private String name;
    private List<DataModel> models;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataModel> getModels() {
        return models;
    }

    public void setModels(List<DataModel> models) {
        this.models = models;
    }
}

package com.chw.generator.model;

import java.util.Map;

/**
 * 数据模型
 *
 * @author chw
 */
public class DataModel {
    private String propertyType;
    private String propertyName;
    private String label;
    private boolean showInQueryRegion;
    private boolean notShowInTableRegion;
    private String controlType;
    private Map controlInitParam;

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isShowInQueryRegion() {
        return showInQueryRegion;
    }

    public void setShowInQueryRegion(boolean showInQueryRegion) {
        this.showInQueryRegion = showInQueryRegion;
    }

    public boolean isNotShowInTableRegion() {
        return notShowInTableRegion;
    }

    public void setNotShowInTableRegion(boolean notShowInTableRegion) {
        this.notShowInTableRegion = notShowInTableRegion;
    }

    public String getControlType() {
        return controlType;
    }

    public void setControlType(String controlType) {
        this.controlType = controlType;
    }

    public Map getControlInitParam() {
        return controlInitParam;
    }

    public void setControlInitParam(Map controlInitParam) {
        this.controlInitParam = controlInitParam;
    }
}

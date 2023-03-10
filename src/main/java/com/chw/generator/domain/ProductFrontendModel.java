package com.chw.generator.domain;

import com.alibaba.fastjson.JSON;
import com.chw.generator.annotation.EngineType;
import com.chw.generator.annotation.Vo;
import com.chw.generator.model.DataModel;
import com.chw.generator.model.TableModel;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author chw
 */
@EngineType(value = "freeMaker")
public class ProductFrontendModel implements ProduceModel<TableModel>{
    @Override
    public TableModel ProduceModel(Class model) throws Exception {
      if(model==null) return null;
      TableModel tableModel=new TableModel();
      tableModel.setName(model.getSimpleName());
       Field[] fields= model.getDeclaredFields();
       if(fields.length>0){
           List<DataModel> dataModels=new ArrayList<>();
           for (Field field : fields) {
               if(!field.isAccessible()){
                   field.setAccessible(true);
               }
               DataModel dataModel=new DataModel();
               dataModel.setPropertyType(field.getType().getSimpleName());
               dataModel.setPropertyName(field.getName());
               Vo vo= field.getAnnotation(Vo.class);
               if(vo!=null){
                   dataModel.setLabel(vo.value());
                   dataModel.setShowInQueryRegion(vo.showInQueryRegion());
                   dataModel.setNotShowInTableRegion(vo.notShowInTableRegion());
                   dataModel.setControlType(vo.controlType());
                   if(StringUtils.hasLength(vo.controlInitParam())){
                       Map map = (Map) JSON.parse(vo.controlInitParam());
                       dataModel.setControlInitParam(map);
                   }
               }
               dataModels.add(dataModel);
           }
           tableModel.setModels(dataModels);
       }
        return tableModel;
    }
}

package com.dee.web.sample01.service.converter;

import java.util.List;

/**
 * @author dien.nguyen
 **/

public interface Converter<Data, Model> {
    
    Model convert2Model(Data source);
    
    List<Model> convert2Models(List<Data> sources);
    
    void convert2Model(Data source, Model dest);
    
    Data convert2Data(Model source);
    
    List<Data> convert2Datas(List<Model> sources);
    
    void convert2Data(Model source, Data dest);
    
}

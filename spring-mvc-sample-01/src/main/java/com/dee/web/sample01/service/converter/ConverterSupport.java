package com.dee.web.sample01.service.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dien.nguyen
 **/

public abstract class ConverterSupport<Data, Model> implements Converter<Data, Model> {
    
    protected abstract Data createData();
    
    protected abstract Model createModel();
    
    @Override
    public List<Data> convert2Datas(List<Model> sources) {
        if(sources == null || sources.isEmpty()) {
            return new ArrayList<Data>();
        }
        List<Data> dests = new ArrayList<Data>();
        for(Model source : sources) {
            Data data = convert2Data(source);
            if(data != null) {
                dests.add(data);
            }
        }
        return dests;
    }
    
    @Override
    public Data convert2Data(Model source) {
        if(source == null) {
            return null;
        }
        Data dest = createData();
        convert2Data(source, dest);
        
        return dest;
    }
    
    @Override
    public List<Model> convert2Models(List<Data> sources) {
        if(sources == null || sources.isEmpty()) {
            return new ArrayList<Model>();
        }
        List<Model> dests = new ArrayList<Model>();
        for(Data source : sources) {
            Model data = convert2Model(source);
            if(data != null) {
                dests.add(data);
            }
        }
        return dests;
    }
    
    @Override
    public Model convert2Model(Data source) {
        if(source == null) {
            return null;
        }
        Model dest = createModel();
        convert2Model(source, dest);
        
        return dest;
    }
    
}

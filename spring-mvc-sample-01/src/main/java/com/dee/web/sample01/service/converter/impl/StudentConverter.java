package com.dee.web.sample01.service.converter.impl;

import org.springframework.stereotype.Service;

import com.dee.web.sample01.dto.StudentData;
import com.dee.web.sample01.model.StudentModel;
import com.dee.web.sample01.service.converter.ConverterSupport;

/**
 * @author dien.nguyen
 **/
@Service("studentConverter")
public class StudentConverter extends ConverterSupport<StudentData, StudentModel> {

    @Override
    public void convert2Model(StudentData source, StudentModel dest) {
        if(source == null || dest == null) {
            return;
        }
        dest.setId(source.getId());
        dest.setEmail(source.getEmail());
        dest.setFirstName(source.getFirstName());
        dest.setLastName(source.getLastName());
        dest.setDateOfBirth(source.getDateOfBirth());
        dest.setGender(source.getGender());
    }

    @Override
    public void convert2Data(StudentModel source, StudentData dest) {
        if(source == null || dest == null) {
            return;
        }
        dest.setId(source.getId());
        dest.setEmail(source.getEmail());
        dest.setFirstName(source.getFirstName());
        dest.setLastName(source.getLastName());
        dest.setDateOfBirth(source.getDateOfBirth());
        dest.setFullName(source.getFirstName() + " " + source.getLastName());
        dest.setGender(source.getGender());
    }

    @Override
    protected StudentData createData() {
        return new StudentData();
    }

    @Override
    protected StudentModel createModel() {
        return new StudentModel();
    }
    
}

package com.dee.web.sample01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dee.web.sample01.dao.StudentDao;
import com.dee.web.sample01.dto.StudentData;
import com.dee.web.sample01.model.StudentModel;
import com.dee.web.sample01.service.IdGeneratorService;
import com.dee.web.sample01.service.StudentService;
import com.dee.web.sample01.service.converter.Converter;

/**
 * @author dien.nguyen
 **/

@Service
public class DefaultStudentService implements StudentService{
    
    @Autowired
    private StudentDao studentDao;
    
    @Autowired
    private IdGeneratorService idGeneratorService;
    
    @Autowired
    @Qualifier("studentConverter")
    private Converter<StudentData, StudentModel> studentConverter;
    
    @Override
    public StudentData get(String id) {
        StudentModel studentModel = studentDao.findById(id);
        return studentConverter.convert2Data(studentModel);
    }

    @Override
    public List<StudentData> getAll() {
        List<StudentModel> studentModels = studentDao.findAll();
        return studentConverter.convert2Datas(studentModels);
    }

    @Override
    public StudentData add(StudentData student) {
        if(student == null) {
            return null;
        }
        String id = idGeneratorService.generate("STD");
        System.out.println("Generated Student ID: " + id);
        student.setId(id);
        
        StudentModel studentModel = new StudentModel();
        studentConverter.convert2Model(student, studentModel);
        
        studentModel = studentDao.save(studentModel);
        return studentConverter.convert2Data(studentModel);
    }

    @Override
    public boolean update(StudentData student) {
        if(student == null || student.getId() == null || student.getId().isEmpty()) {
            return false;
        }
        StudentModel oldStudent = studentDao.findById(student.getId());
        if(oldStudent == null) {
            return false;
        }
        StudentModel studentModel = new StudentModel();
        studentConverter.convert2Model(student, studentModel);
        studentDao.update(studentModel);
        return true;
    }

    @Override
    public boolean delete(String id) {
        StudentModel student = studentDao.findById(id);
        if(student == null) {
            return false;
        }
        return studentDao.remove(id);
    }

}

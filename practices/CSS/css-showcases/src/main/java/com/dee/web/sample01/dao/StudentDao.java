package com.dee.web.sample01.dao;

import java.util.List;

import com.dee.web.sample01.model.StudentModel;

/**
 * @author dien.nguyen
 **/

public interface StudentDao {
    
    StudentModel findById(String id);
    
    List<StudentModel> findAll();
    
    StudentModel save(StudentModel student);
    
    void update(StudentModel student);
    
    boolean remove(String id);
}

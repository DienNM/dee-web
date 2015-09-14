package com.dee.web.sample01.service;

import java.util.List;

import com.dee.web.sample01.dto.StudentData;

/**
 * @author dien.nguyen
 **/

public interface StudentService {
    
    StudentData get(String id);
    
    List<StudentData> getAll();
    
    StudentData add(StudentData student);
    
    boolean update(StudentData student);
    
    boolean delete(String id);
    
}

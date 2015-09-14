package com.dee.web.sample01.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import com.dee.web.sample01.dao.StudentDao;
import com.dee.web.sample01.model.StudentModel;

/**
 * @author dien.nguyen
 **/

@Service
public class DefaultStudentDao implements StudentDao {
    
    private static ConcurrentMap<String, StudentModel> data = new ConcurrentHashMap<String, StudentModel>();

    @Override
    public StudentModel findById(String id) {
        return data.get(id);
    }

    @Override
    public List<StudentModel> findAll() {
        return new ArrayList<StudentModel>(data.values());
    }

    @Override
    public StudentModel save(StudentModel student) {
        System.out.println("[DAO] Adding student: " + student.getId());
        data.put(student.getId(), student);
        
        return student;
    }

    @Override
    public void update(StudentModel student) {
        data.put(student.getId(), student);
    }

    @Override
    public boolean remove(String id) {
        return data.remove(id) != null;
    }
    
}

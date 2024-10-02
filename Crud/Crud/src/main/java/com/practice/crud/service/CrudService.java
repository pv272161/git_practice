package com.practice.crud.service;

import com.practice.crud.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrudService {
    public Student createStudent(Student student);
    public Student updateStudent(Long id, Student student);
    public Page<Student> allStudents(int pageNum, int pageSize, String sName);
    public  Student getById(Long id);
    public void deleteStudent(Long id);
}

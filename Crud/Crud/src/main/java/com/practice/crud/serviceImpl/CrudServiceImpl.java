package com.practice.crud.serviceImpl;

import com.practice.crud.entity.Student;
import com.practice.crud.exceptions.StudentNotFoundException;
import com.practice.crud.repository.CrudRepo;
import com.practice.crud.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CrudServiceImpl implements CrudService {
    private final CrudRepo repo;

    public CrudServiceImpl(CrudRepo repo) {
        this.repo = repo;
    }

    @Override
    public Student createStudent(Student student) {
       return  repo.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = repo.findById(id).orElseThrow(() -> new StudentNotFoundException("Student NOT Found"));
        existingStudent.setSId(student.getSId());
        existingStudent.setSName(student.getSName());
        existingStudent.setSEmail(student.getSEmail());
        existingStudent.setSDob(student.getSDob());
        return repo.save(existingStudent);
    }

    @Override
    public Page<Student> allStudents(int pageNum, int pageSize, String sName) {
        Pageable pageable= PageRequest.of(pageNum,pageSize,Sort.by(sName));
        return repo.findAll(pageable);
    }


    @Override
    public Student getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new StudentNotFoundException("No student with id :" + " id"));
    }

    @Override
    public void deleteStudent(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else throw new StudentNotFoundException("Sorry student NOT found");
    }
}

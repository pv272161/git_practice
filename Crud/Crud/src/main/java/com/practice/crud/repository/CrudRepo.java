package com.practice.crud.repository;

import com.practice.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepo extends JpaRepository<Student, Long> {
}

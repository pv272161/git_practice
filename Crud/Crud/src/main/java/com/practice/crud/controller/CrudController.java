package com.practice.crud.controller;

import com.practice.crud.entity.Student;
import com.practice.crud.serviceImpl.CrudServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CrudController {
    private  final CrudServiceImpl service;
    public CrudController(CrudServiceImpl service) {
        this.service = service;
    }
    @PostMapping("/post/student")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> postStudent(@RequestBody Student student){
        return  ResponseEntity.ok(service.createStudent(student));
    }
    @PutMapping("/put/{id}/student")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> putStudent(@PathVariable  Long id, @RequestBody  Student student ){
        return ResponseEntity.ok(service.updateStudent(id, student));
    }
    @GetMapping("/get/")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Page<Student>> getAllStudents(@RequestParam (defaultValue = "0") int pageNum,
                                                        @RequestParam (defaultValue = "5") int pageSize,
                                                        @RequestParam String sName){
        return  ResponseEntity.ok(service.allStudents(pageNum,pageSize,sName));
    }
    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Student> getById(@PathVariable  Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @DeleteMapping("/delete/")
    @ResponseStatus(HttpStatus.OK)
    public void removeStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }
}

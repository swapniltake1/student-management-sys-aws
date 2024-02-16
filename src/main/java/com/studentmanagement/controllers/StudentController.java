package com.studentmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    

    @GetMapping("/get-all")
    public ResponseEntity<List<Student>> getAllStudent() {
        try {
            List<Student> allStudents = studentService.getAllStudents();
            log.info("Retrieved all students successfully.");
            return new ResponseEntity<>(allStudents, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while retrieving all students.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        try {
            Student student = studentService.getStudentById(id);
            log.info("Retrieved student with ID: {} successfully.", id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while retrieving student with ID: {}.", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        try {
            Student addedStudent = studentService.addStudent(student);
            log.info("Added student with ID: {}", addedStudent.getStudentId());
            return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error occurred while adding student.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(id, student);
            log.info("Updated student with ID: {}", id);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while updating student with ID: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        try {
            studentService.deleteStudent(id);
            log.info("Deleted student with ID: {}", id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error occurred while deleting student with ID: {}", id, e);
            return new ResponseEntity<>("Failed to delete student", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

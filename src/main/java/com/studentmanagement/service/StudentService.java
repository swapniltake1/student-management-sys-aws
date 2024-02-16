package com.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.dao.StudentRepository;
import com.studentmanagement.entity.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        try {
            List<Student> allStudents = studentRepository.findAll();
            log.info("Retrieved all students successfully");
            return allStudents;
        } catch (Exception e) {
            log.error("Error occurred while fetching all students", e);
            throw e;
        }
    }

    public Student getStudentById(Long id) {
        try {
            Optional<Student> studentOptional = studentRepository.findByStudentId(id);
            if (studentOptional.isPresent()) {
                log.info("Retrieved student with ID {} successfully", id);
                return studentOptional.get();
            } else {
                log.warn("Student with ID {} not found", id);
                throw new RuntimeException("Student not found with ID " + id);
            }
        } catch (Exception e) {
            log.error("Error occurred while fetching student with ID {}", id, e);
            throw e;
        }
    }

    public Student addStudent(Student student) {
        try {
            Student savedStudent = studentRepository.save(student);
            log.info("Student added successfully with ID: {}", savedStudent.getStudentId());
            return savedStudent;
        } catch (Exception e) {
            log.error("Error occurred while adding student", e);
            throw e;
        }
    }

    public Student updateStudent(Long id, Student student) {
        try {
            Optional<Student> existingStudentOptional = studentRepository.findByStudentId(id);
            if (existingStudentOptional.isPresent()) {
                Student existingStudent = existingStudentOptional.get();
                existingStudent.setStudentName(student.getStudentName());
                existingStudent.setStudentPhone(student.getStudentPhone());
                existingStudent.setStudentAddress(student.getStudentAddress());
                existingStudent.setStudentClass(student.getStudentClass());
                existingStudent.setStudentMail(student.getStudentMail());
                Student updatedStudent = studentRepository.save(existingStudent);
                log.info("Student with ID {} updated successfully", id);
                return updatedStudent;
            } else {
                log.warn("Student with ID {} not found, unable to update", id);
                throw new RuntimeException("Student not found with ID " + id);
            }
        } catch (Exception e) {
            log.error("Error occurred while updating student with ID {}", id, e);
            throw e;
        }
    }

    public void deleteStudent(int id) {
        try {
            if (studentRepository.findByStudentId(id) != null) {
                studentRepository.deleteById(id);
                log.info("Student with ID {} deleted successfully", id);
            } else {
                log.warn("Student with ID {} not found, unable to delete", id);
                throw new RuntimeException("Student not found with ID " + id);
            }
        } catch (Exception e) {
            log.error("Error occurred while deleting student with ID {}", id, e);
            throw e;
        }
    }
}

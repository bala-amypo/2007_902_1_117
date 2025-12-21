package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // ✅ Constructor Injection only
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {

        studentRepository.findByRollNo(student.getRollNo())
                .ifPresent(s -> {
                    throw new IllegalArgumentException("Roll number already exists");
                });

        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

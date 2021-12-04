package com.example.backend.service;

import com.example.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List getAllStudents() {
        return studentRepository.findAll();
    }
}

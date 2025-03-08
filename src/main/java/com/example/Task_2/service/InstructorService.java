package com.example.Task_2.service;

import com.example.Task_2.model.Instructor;
import com.example.Task_2.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorByID(Integer id) {
        return instructorRepository.findById(id);
    }

    public Instructor getInstructorByEmail(String email) {
        return instructorRepository.findInstructorByEmail(email);
    }
}
package com.example.springjdbcboot.service;

import com.example.springjdbcboot.dto.StudentDto;
import com.example.springjdbcboot.model.Student;
import com.example.springjdbcboot.repository.JDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private final JDBCRepository jdbcRepository;

    @Autowired
    public StudentService(JDBCRepository jdbcRepository) {
        this.jdbcRepository = jdbcRepository;
    }


    public void addPerson(StudentDto studentDto) {
        Student student = new Student(studentDto.getAge(), studentDto.getName(),studentDto.getSurname());
      jdbcRepository.addStudentDB(student);
    }

    public void deletePerson(int id) {
           jdbcRepository.deletePersonDB(id);
    }

    public List<Student> getAllStudents() {
        return jdbcRepository.findAllStudents();
    }


    public Student findByNameStudent(String name) {
        return jdbcRepository.findStudent(name);
    }

    public void updateStudent(StudentDto studentDto, int id) {
        jdbcRepository.updateByidStudent(studentDto,id);
    }

    public List <Student> adultStudents(int age) {
        return jdbcRepository.students18AndMore(age);
    }

    public double average() {
        return jdbcRepository.midAgeOfStudents();
    }

    public Map<String, Integer> countOfSurnames() {
        return jdbcRepository.countOfStudentsByGroup();
    }
}

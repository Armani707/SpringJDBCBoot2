package com.example.springjdbcboot.dao;

import com.example.springjdbcboot.dto.StudentDto;
import com.example.springjdbcboot.model.Student;

import java.util.List;
import java.util.Map;

//интерфейс для работы с базой данных. Где прописываются шаблонные методы для
//работы с БД. Например изменить данные, удалить, внести новое.
public interface StudentDao {
    void addStudentDB(Student student);
    void deletePersonDB(int id);
    List<Student> findAllStudents();
    Student findStudent(String name);
   void updateByidStudent(StudentDto studentDto, int id);
   List<Student> students18AndMore(int age);
   double midAgeOfStudents();
   Map<String, Integer> countOfStudentsByGroup();
}

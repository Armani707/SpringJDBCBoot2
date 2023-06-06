package com.example.springjdbcboot.repository;

import com.example.springjdbcboot.dao.StudentDao;
import com.example.springjdbcboot.dto.StudentDto;
import com.example.springjdbcboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//insert, update, delete выполняются методом update

@Repository
public class JDBCRepository implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addStudentDB(Student student) {
        jdbcTemplate.update("insert into student (age, name, surname) values (?,?,?)", student.getAge(), student.getName(), student.getSurname());

    }

    public void deletePersonDB(int id) {
        jdbcTemplate.update("delete from student where id =?", id);

    }

    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        jdbcTemplate.query("select * from student", new Object[]{/*здесь пишутся параметры нашего метода*/}, rs /*получает значения по колонкам*/ -> {
            students.add(new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
        }); // если в списке 100+ студентов, все будут пересчитаны все равно
        return students;
    }

    public Student findStudent(String name) {
        Student student = new Student();
        jdbcTemplate.query("select * from student where name =?", new Object[]{name}, rs -> {
            student.setId(rs.getInt(1));
            student.setAge(rs.getInt(2));
            student.setName(rs.getString(3));
            student.setSurname(rs.getString(4));
        });
        return student;
    }

    public void updateByidStudent(StudentDto studentDto, int id) {
        System.out.println(jdbcTemplate.update("update student set age =?, name =?, surname =? where id =?",
                studentDto.getAge(), studentDto.getName(), studentDto.getSurname(), id));
    }

    public List<Student> students18AndMore(int age) {
        List<Student> students = new ArrayList<>();
        jdbcTemplate.query("select * from student where age >=?", new Object[]{age}, rs -> {
            students.add(new Student(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
        });
        return students;
    }

    public double midAgeOfStudents() {
        //(1 sposob)List <Student> students = new ArrayList<>();
        List<Double> avgList = new ArrayList<>();
        jdbcTemplate.query("select avg (age) from student", new Object[]{}, rs -> {
            //students.add(new Student(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getString(4)));
            avgList.add(rs.getDouble(1));
        });
        //return students.stream().mapToDouble(student -> student.getAge()).summaryStatistics().getAverage();
        return avgList.get(0);
    }

    public Map<String, Integer> countOfStudentsByGroup() {
        Map<String, Integer> countList = new HashMap<>();
        jdbcTemplate.query("select surname, count (*) from student group by surname", new Object[]{}, rs -> {
            countList.put(rs.getString(1), rs.getInt(2));
        });

        return countList;
    }


}

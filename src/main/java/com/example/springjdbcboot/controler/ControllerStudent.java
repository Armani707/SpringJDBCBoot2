package com.example.springjdbcboot.controler;
import com.example.springjdbcboot.dto.StudentDto;
import com.example.springjdbcboot.model.Student;
import com.example.springjdbcboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControllerStudent {

    private final StudentService studentService;

    @Autowired
    public ControllerStudent(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public void create (@RequestBody StudentDto studentDto) {
            studentService.addPerson(studentDto);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam("id") int id/*BindingResult bindingResult*/) {
       /* if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError());
        }*/
        studentService.deletePerson(id);
    }

    @GetMapping("/findall")
    public List<Student> findAll () {
        return studentService.getAllStudents();
    }

    @GetMapping("/findbyname/{name}")
    public Student findByName (@PathVariable("name") String name) {
        return studentService.findByNameStudent(name);
    }

    @PatchMapping("/update/{id}")
    public void updateById (@RequestBody StudentDto studentDto, @PathVariable("id") int id) {
        studentService.updateStudent(studentDto, id);
    }

    @GetMapping("/adultStudents/{age}")
    public List <Student> findAdultStudents(@PathVariable ("age") int age) {
        return studentService.adultStudents(age);
    }

    @GetMapping("/average")
    public double average () {
        return studentService.average();
    }

    @GetMapping("/getbygroup")
    public Map<String, Integer> countOfSurnames () {
        return studentService.countOfSurnames();
    }
    //сгруппировать студентов по фамилии и показать количество
    //MAP <String, List <Student> list>

}

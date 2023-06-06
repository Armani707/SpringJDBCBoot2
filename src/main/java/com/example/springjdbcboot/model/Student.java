package com.example.springjdbcboot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;

   /* public void setId(int id) {
        this.id = id;
    }*/

    // @Min(value = 18, message = "wrong age")
   // @Max(value = 89, message = "wrong age")
    private int age;

   // @Size(min = 2, max = 30)
    private String name;

   // @Size(min = 2, max = 30)
    private String surname;

    public Student(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
}
package com.example.springjdbcboot.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
//класс с которым взаимодействует только пользователь,
// где ему не видны скрытые данные (например id, номер счета пользователя и тд)
@Data
@AllArgsConstructor
public class StudentDto {

   // @Min(value = 18, message = "wrong age")
   // @Max(value = 89, message = "wrong age")
    private int age;

   // @Size(min = 2, max = 30)
    private String name;

   // @Size(min = 2, max = 30)
    private String surname;
}

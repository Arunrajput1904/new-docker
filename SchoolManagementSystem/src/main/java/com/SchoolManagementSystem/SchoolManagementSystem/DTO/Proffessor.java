package com.SchoolManagementSystem.SchoolManagementSystem.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Proffessor {
@NotNull
    Long id;
@NotEmpty
    String name;


    List<Subject> sublist;

    List<Student> studentList;
}

package com.SchoolManagementSystem.SchoolManagementSystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {

    @NotNull
    Long id;

    @NotEmpty
    String name;

    List<Proffessor> proffessorList;

    List<Subject> subjectList=new ArrayList<>();


    AdminRole adminRole;
}

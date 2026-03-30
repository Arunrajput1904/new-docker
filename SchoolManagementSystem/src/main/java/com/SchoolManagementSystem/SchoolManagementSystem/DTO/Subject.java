package com.SchoolManagementSystem.SchoolManagementSystem.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Subject {

    Long id;


    @NotEmpty(message = " not empty")
    String title;

    Proffessor proffessor;
@JsonIgnore
    List<Student> studentList=new ArrayList<>();

}

package com.SchoolManagementSystem.SchoolManagementSystem.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Proffessor {
@NotNull
    Long id;
@NotEmpty
    String name;


@JsonIgnore
        @ToString.Exclude
    List<Subject> sublist;

    List<Student> studentList;
}

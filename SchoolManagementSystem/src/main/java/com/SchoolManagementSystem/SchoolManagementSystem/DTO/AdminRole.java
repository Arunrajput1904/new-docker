package com.SchoolManagementSystem.SchoolManagementSystem.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminRole {



    Long id;

    @NotNull
    @Size(min = 100, max = 100000, message = "Fees Val not valid")
    int fees;

    Student student;

}

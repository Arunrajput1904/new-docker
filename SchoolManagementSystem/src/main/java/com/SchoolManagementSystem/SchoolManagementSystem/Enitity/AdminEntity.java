package com.SchoolManagementSystem.SchoolManagementSystem.Enitity;

import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class AdminEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    int fees;

    @JsonIgnore
//    @ToString.Exclude
@OneToOne(mappedBy = "admin")
    StudentEntity student;

}

package com.SchoolManagementSystem.SchoolManagementSystem.Enitity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class SubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,length = 40)
    String title;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    ProfessorEntity professor;

    @ManyToMany(mappedBy = "subjectEntityList")
            @ToString.Exclude
    List<StudentEntity> studentList=new ArrayList<>();

}

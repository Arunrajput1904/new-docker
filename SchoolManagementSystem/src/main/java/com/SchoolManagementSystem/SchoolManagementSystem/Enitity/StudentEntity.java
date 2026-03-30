package com.SchoolManagementSystem.SchoolManagementSystem.Enitity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString

public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    Long id;

    @Column(nullable = false, length = 40)
    @ToString.Include
    String name;

    @ManyToMany(mappedBy = "studentList")
    @JsonIgnore
    @ToString.Exclude
    List<ProfessorEntity> professorEntityList = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ToString.Exclude
    @JoinTable(
            name = "Sub_student_table",
            joinColumns = @JoinColumn(name = "Stud_id"),
            inverseJoinColumns = @JoinColumn(name = "Sub_id")
    )
    @JsonIgnore
    List<SubjectEntity> subjectEntityList = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "admin_id")
            @ToString.Exclude
    AdminEntity admin;
}

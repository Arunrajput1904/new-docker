package com.SchoolManagementSystem.SchoolManagementSystem.Enitity;


import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ProfessorEntity {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false,length = 40)
    String name;


    @ToString.Exclude
    @OneToMany(mappedBy = "professor",fetch =FetchType.EAGER ,cascade = {CascadeType.ALL} , orphanRemoval = true)
            @JsonIgnore
    List<SubjectEntity> sublist;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "professor_student",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
@ToString.Exclude
@JsonIgnore
    List<StudentEntity> studentList;



}

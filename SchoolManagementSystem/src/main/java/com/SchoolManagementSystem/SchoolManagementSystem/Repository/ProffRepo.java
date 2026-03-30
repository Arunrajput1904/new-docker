package com.SchoolManagementSystem.SchoolManagementSystem.Repository;

import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProffRepo extends JpaRepository<ProfessorEntity,Long> {

    @Query("SELECT p FROM ProfessorEntity p WHERE p.name=:name ")
    ProfessorEntity  findByName(@Param("name") String name);

    @Query("SELECT DISTINCT p FROM ProfessorEntity p LEFT JOIN FETCH p.sublist s LEFT JOIN FETCH p.studentList st")
    List<ProfessorEntity> findAllele();


}

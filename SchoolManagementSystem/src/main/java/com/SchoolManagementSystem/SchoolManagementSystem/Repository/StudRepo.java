package com.SchoolManagementSystem.SchoolManagementSystem.Repository;

import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.AdminEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.ProfessorEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.StudentEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudRepo extends JpaRepository<StudentEntity,Long> {

    List<StudentEntity> findByNameContainingIgnoreCase(String name, Pageable pageable);



    @Query("Select e from StudentEntity e  LEFT JOIN   e.admin a where a.id IS NOT NULL ")
    List<StudentEntity> findAllStu();

    @Query("Select e from StudentEntity e where e.admin IS NOT NULL AND  e.admin.fees > 1500 ")
    List<StudentEntity> findAllStudentBycond();


}

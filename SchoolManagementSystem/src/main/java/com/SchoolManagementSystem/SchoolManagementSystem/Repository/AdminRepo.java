package com.SchoolManagementSystem.SchoolManagementSystem.Repository;

import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long> {


    @Query("Select e from AdminEntity e  LEFT JOIN  e.student s ")
    List<AdminEntity> alllget();

}




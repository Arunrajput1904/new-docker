package com.SchoolManagementSystem.SchoolManagementSystem.Repository;

import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.ProfessorEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.SubjectEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity,Long> {

    @Query("SELECT s FROM SubjectEntity s")
    List<SubjectEntity> findAllSub();


    @Query("Select e.title from SubjectEntity e where  e.id=:l ")
    String findByid(long l);

    @Modifying
    @Transactional
    @Query("Update SubjectEntity e Set e.title=:title where  e.id =:id")
    int updateData(@Param("title")  String title, @Param("id") long id);

}

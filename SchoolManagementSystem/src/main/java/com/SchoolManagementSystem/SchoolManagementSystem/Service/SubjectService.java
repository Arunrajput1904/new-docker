package com.SchoolManagementSystem.SchoolManagementSystem.Service;

import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Proffessor;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.ProfessorEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.SubjectEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.ProffRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.StudRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.SubjectRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

@Data
public class SubjectService {
    @Autowired
    ModelMapper mapper;
    private final ProffRepo repo;

    private final SubjectRepo subRepo;

    private final StudRepo studRepo;
    public Subject getById(Long id) {

        Optional<SubjectEntity> enn= subRepo.findById(id);

        if(enn.isEmpty()){
            return null;
        }
        return mapper.map(enn,Subject.class);

    }

    public Subject savedetails(Subject subject) {

        SubjectEntity prof=mapper.map(subject,SubjectEntity.class);
        return  mapper.map(subRepo.save(prof),Subject.class);


    }


    public Subject setproff(Long subId, Long proffId) {

        SubjectEntity sub=subRepo.findById(subId).orElse(null);

        ProfessorEntity proff=repo.findById(proffId).orElse(null);

        if(sub==null || proff ==null){
            return null;
        }

        sub.setProfessor(proff);

        return  mapper.map(sub,Subject.class);




    }
}

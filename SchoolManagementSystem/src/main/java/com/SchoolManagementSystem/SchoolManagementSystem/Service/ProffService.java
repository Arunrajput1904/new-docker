package com.SchoolManagementSystem.SchoolManagementSystem.Service;

import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Proffessor;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.ProfessorEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.StudentEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.SubjectEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Exceptions.InvalidArgument;
import com.SchoolManagementSystem.SchoolManagementSystem.Exceptions.ResourceNotFoundException;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.ProffRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.StudRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.SubjectRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

@Data

public class ProffService {



    @Autowired
    ModelMapper mapper;
    private final ProffRepo repo;

    private final SubjectRepo subRepo;

    private final StudRepo studRepo;
    public Proffessor getById(Long id) {

        Optional<ProfessorEntity> enn= repo.findById(id);

        if(enn.isEmpty()){
            return null;
        }
        return mapper.map(enn,Proffessor.class);

    }

    public Proffessor savedetails(Proffessor proffessor) {

        ProfessorEntity prof=mapper.map(proffessor,ProfessorEntity.class);
        return  mapper.map(repo.save(prof),Proffessor.class);


    }

    public List<Subject> getAllsubject(Long id) {
        Optional<ProfessorEntity> enn=repo.findById(id);
        if(enn.isEmpty()){
            throw new InvalidArgument("Id is invalid");
        }

        List<SubjectEntity> subjectEntities=enn.get().getSublist();

        return  subjectEntities.stream().map(enitity->mapper.map(enitity,Subject.class)).toList();


    }

    public List<Student> getAllStudent(Long id) {
        Optional<ProfessorEntity> enn=repo.findById(id);
        if(enn.isEmpty()){
            throw new InvalidArgument("Id is invalid");
        }

        List<StudentEntity> subjectEntities=enn.get().getStudentList();

        return  subjectEntities.stream().map(enitity->mapper.map(enitity,Student.class)).toList();

    }

    @Transactional
    public Boolean InitstudByProf(Long sid, Long pid) {

     Optional<ProfessorEntity> proff=repo.findById(pid);
     Optional<StudentEntity> studd=studRepo.findById(sid);


     if(proff.isEmpty() || studd.isEmpty()){
         throw new InvalidArgument("Id is invalid");
     }

     proff.get().getStudentList().add(studd.get());
     studd.get().getProfessorEntityList().add(proff.get());


     return true;
    }

    @Transactional
    public Boolean removesubject(Long proffid, Long subid) {

        Optional<ProfessorEntity> proff=repo.findById(proffid);
        Optional<SubjectEntity> sub=subRepo.findById(subid);


        if(proff.isEmpty() || sub.isEmpty()){
            return false;
        }

        proff.get().getSublist().remove(sub.get());

        sub.get().setProfessor(null);

        return false;
    }

    @Transactional
    public Boolean Addsubject(String name, Subject subject) {


        ProfessorEntity proff=repo.findByName(name);

        if(proff==null || subject==null){
            return  false;
        }


        SubjectEntity sub=mapper.map(subject,SubjectEntity.class);
        sub.setProfessor(proff);
        proff.getSublist().add(sub);
        return true;
    }

    public List<Proffessor> getAll() {


        List<ProfessorEntity> list=repo.findAllele();



        return  list.stream().map(item->mapper.map(item,Proffessor.class)).toList();

    }
}

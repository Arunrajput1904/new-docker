package com.SchoolManagementSystem.SchoolManagementSystem.Service;

import com.SchoolManagementSystem.SchoolManagementSystem.DTO.AdminRole;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.AdminEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.StudentEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.SubjectEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.ProffRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.StudRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.SubjectRepo;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor

@Data
@Service
public class StudService {



    private  final int pageSize=5;
    @Autowired
    ModelMapper mapper;
    private final ProffRepo repo;

    private final SubjectRepo subRepo;

    private final StudRepo studRepo;
    public Student getById(Long id) {

        Optional<StudentEntity> enn= studRepo.findById(id);

        if(enn.isEmpty()){
            return null;
        }
        return mapper.map(enn,Student.class);

    }

    public Student savedetails(Student student) {

        StudentEntity prof=mapper.map(student,StudentEntity.class);
        return  mapper.map(studRepo.save(prof),Student.class);


    }

    public List<Subject> getAllsubject(Long id) {
        Optional<StudentEntity> enn=studRepo.findById(id);
        if(enn.isEmpty()){
            return  null;
        }

        List<SubjectEntity> subjectEntities=enn.get().getSubjectEntityList();

        return  subjectEntities.stream().map(enitity->mapper.map(enitity,Subject.class)).toList();


    }


    @Transactional
    public Boolean InitsubBystu(Long stuid, Long subid) {

        Optional<StudentEntity> Studd=studRepo.findById(stuid);
        Optional<SubjectEntity> subb=subRepo.findById(subid);


        if(subb.isEmpty() || Studd.isEmpty()){
            return false;
        }

        Studd.get().getSubjectEntityList().add(subb.get());

        subb.get().getStudentList().add(Studd.get());
        return true;
    }


    @Transactional
    public Boolean addsubject(Long stu, Subject subject) {


        StudentEntity student=studRepo.findById(stu).orElse(null);

        if(student==null || subject==null){
            return  false;
        }


        SubjectEntity sub=mapper.map(subject,SubjectEntity.class);
        student.getSubjectEntityList().add(sub);

        sub.getStudentList().add(student);

        studRepo.save(student);


        return true;
    }




    public List<Student> getAll(String name, String sortBody, Integer pageNumber) {


        List<StudentEntity> list=studRepo.findByNameContainingIgnoreCase(name, PageRequest.of(pageNumber,pageSize, Sort.by(
                Sort.Order.asc(sortBody),
                Sort.Order.asc("id")
        ) ));

     return  list.stream().map(entity-> mapper.map(entity,Student.class)).toList();


    }

    public Student addadmin(Long stuid, AdminRole adminRole) {

        StudentEntity student=studRepo.findById(stuid).orElse(null);

        if(student==null){
            return null;
        }

        AdminEntity admin=mapper.map(adminRole,AdminEntity.class);
        student.setAdmin(admin);
        admin.setStudent(student);


        return mapper.map(studRepo.save(student),Student.class);

    }

    public Student updateadmin(Long stuid,AdminRole adminRole) {
        StudentEntity student=studRepo.findById(stuid).orElse(null);

        if(student==null){
            return null;
        }

        AdminEntity admin=mapper.map(adminRole,AdminEntity.class);
        student.setAdmin(admin);
        admin.setStudent(student);


        return mapper.map(studRepo.save(student),Student.class);

    }

    public AdminRole getadmin(Long id) {
        StudentEntity student=studRepo.findById(id).orElse(null);

        if(student==null){
            return null;
        }

        return mapper.map(student.getAdmin(),AdminRole.class);
    }


}

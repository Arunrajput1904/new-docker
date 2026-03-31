package com.SchoolManagementSystem.SchoolManagementSystem.Controller;


import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Proffessor;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.ProfessorEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Exceptions.ResourceNotFoundException;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.ProffService;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.StudService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor

@RestController

@RequestMapping("/professor")
public class ProffController {


//@Autowired
    private final ProffService proffService;

    @Autowired
    StudService studService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Proffessor> getById(@PathVariable Long id){
        Proffessor proffessor=proffService.getById(id);
        if(proffessor==null){
            throw  new ResourceNotFoundException("This id is not exist in db");
        }
        return ResponseEntity.ok(proffessor);

    }

    @PostMapping("/post")
    public  ResponseEntity<Proffessor> getbySave(@RequestBody @Valid  Proffessor proffessor)
    {
        return ResponseEntity.ok(proffService.savedetails(proffessor));
    }


    @GetMapping("/getsub/{id}")
    public ResponseEntity<List<Subject>> getAllsubject(@PathVariable Long id){
          List<Subject> subjectList=proffService.getAllsubject(id);

          if(subjectList.isEmpty()){
              throw new ResourceNotFoundException("List is empty , there is no items in db");

          }
          return ResponseEntity.ok(subjectList);
    }

    @GetMapping("/getstudent/{id}")
    public ResponseEntity<List<Student>> getAllStudent(@PathVariable Long id){
            List<Student> studentList=proffService.getAllStudent(id);
        if(studentList.isEmpty()){
            throw new ResourceNotFoundException("List is empty , there is no items in db");
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/initstud/{sid}/{pid}")
    public  ResponseEntity<Boolean> InitstudByProf(@PathVariable Long sid, @PathVariable Long pid){
        boolean exist=proffService.InitstudByProf(sid,pid);
        if(!exist){
            throw new ResourceNotFoundException("there is no item in db");
        }
        return  ResponseEntity.ok(true);
    }

    @PatchMapping("/removesub/{proffid}/{subid}")
    public  ResponseEntity<Boolean> removesubject(@PathVariable Long proffid,@PathVariable Long subid){

        boolean exist=proffService.removesubject(proffid,subid);
        if(!exist){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(true);
    }

    @PatchMapping("/addsub/{name}")
    public  ResponseEntity<Boolean> Adddsubject(@PathVariable String name,@RequestBody @Valid Subject subject){
        boolean exist= proffService.Addsubject(name,subject);
        if(!exist){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(true);
    }
    @GetMapping("/allprof")
    public ResponseEntity<List<Proffessor> >getAll(){
        List<Proffessor> list=proffService.getAll();
        if(list.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }

}
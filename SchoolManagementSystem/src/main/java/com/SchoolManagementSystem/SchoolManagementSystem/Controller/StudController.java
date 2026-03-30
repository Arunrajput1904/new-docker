package com.SchoolManagementSystem.SchoolManagementSystem.Controller;

import com.SchoolManagementSystem.SchoolManagementSystem.DTO.AdminRole;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Proffessor;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.ProffService;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.StudService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@Valid
@RequestMapping("/student")
public class StudController {



    @Autowired
    StudService studService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id){
        Student student=  studService.getById(id);

        if(student==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping("/post")
    public  ResponseEntity<Student> getbySave(@RequestBody @Valid Student student)
    {
        return ResponseEntity.ok(studService.savedetails(student));
    }


    @GetMapping("/getsub/{id}")
    public ResponseEntity<List<Subject>> getAllsubject(@PathVariable Long id){
        List<Subject> subjectList=studService.getAllsubject(id);
        if(subjectList.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subjectList);
    }



    @PutMapping("/initsub/{stuid}/{subid}")
    public  ResponseEntity<Boolean> InitsubBystu(@PathVariable Long stuid, @PathVariable Long subid){
        boolean exist= studService.InitsubBystu(stuid,subid);
        if(!exist){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(true);
    }

    @PostMapping ("/addsub/{stuid}")
    public  ResponseEntity<Boolean> addsubject(@PathVariable Long stuid,@RequestBody @Valid  Subject subject){
        boolean exist=studService.addsubject(stuid,subject);
        if(!exist){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(true);
    }

    @PostMapping("/postadminadd/{stuid}")
    public  ResponseEntity<Student> addadmin(@PathVariable Long stuid, @RequestBody @Valid  AdminRole adminRole){
        Student student= studService.addadmin(stuid,adminRole);
        if(student==null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(student);
    }
    @PostMapping("/postadminupdate/{stuid}")
    public  ResponseEntity<Student> updateadmin(@PathVariable Long stuid, @RequestBody @Valid  AdminRole adminRole){
        Student student= studService.updateadmin(stuid,adminRole);
        if(student==null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(student);
    }

    @GetMapping("/allstud")
    public ResponseEntity<List<Student>> getAll(@RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "id") String sortBody, @RequestParam(defaultValue = "0") Integer pageNumber){
        List<Student> list=studService.getAll(title,sortBody,pageNumber);
        if(list.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(list);
    }




}

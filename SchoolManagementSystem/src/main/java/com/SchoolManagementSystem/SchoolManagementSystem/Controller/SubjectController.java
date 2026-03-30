package com.SchoolManagementSystem.SchoolManagementSystem.Controller;

import com.SchoolManagementSystem.SchoolManagementSystem.DTO.AdminRole;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Proffessor;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.AdminService;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.SubjectService;
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
@RequestMapping("/Subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;


    @GetMapping("/get/{id}")
    public ResponseEntity<Subject> getById(@PathVariable Long id){
        Subject subject=  subjectService.getById(id);
        if(subject==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subject);
    }

    @PostMapping("/post")
    public  ResponseEntity<Subject> getbySave(@RequestBody @Valid Subject subject)
    {
        return ResponseEntity.ok(subjectService.savedetails(subject));
    }


    @PutMapping("/setproff/{sub_id}/{proff_id}")
     public  ResponseEntity<Subject> setproff(@PathVariable Long sub_id, @PathVariable Long proff_id){
        Subject subject=  subjectService.setproff(sub_id,proff_id);

        if(subject==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(subject);
    }

}

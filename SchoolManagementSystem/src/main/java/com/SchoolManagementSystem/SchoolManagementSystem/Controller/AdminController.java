package com.SchoolManagementSystem.SchoolManagementSystem.Controller;


import com.SchoolManagementSystem.SchoolManagementSystem.DTO.AdminRole;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Proffessor;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Student;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.AdminService;
import com.SchoolManagementSystem.SchoolManagementSystem.Service.StudService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/Admin")
public class AdminController {



    @Autowired
    AdminService adminService;


    @GetMapping("/get/{id}")
    public ResponseEntity<AdminRole> getById(@PathVariable Long id){
        AdminRole role=  adminService.getById(id);
        if(role==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }

    @PostMapping("/post")
    public  ResponseEntity<AdminRole> getbySave(@RequestBody @Valid  AdminRole adminRole)
    {
        return ResponseEntity.ok(adminService.savedetails(adminRole));
    }



}

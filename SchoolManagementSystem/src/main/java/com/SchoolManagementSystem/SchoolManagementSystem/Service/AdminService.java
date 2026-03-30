package com.SchoolManagementSystem.SchoolManagementSystem.Service;


import com.SchoolManagementSystem.SchoolManagementSystem.DTO.AdminRole;
import com.SchoolManagementSystem.SchoolManagementSystem.DTO.Subject;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.AdminEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Enitity.SubjectEntity;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.AdminRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class AdminService {


    private final ModelMapper mapper;

    private final AdminRepo repo;


    public AdminRole getById(Long id) {

        Optional<AdminEntity> enn= repo.findById(id);

        if(enn.isEmpty()){
            return null;
        }
        return mapper.map(enn,AdminRole.class);

    }

    public AdminRole savedetails(AdminRole adminRole) {

        AdminEntity admin=mapper.map(adminRole,AdminEntity.class);
        return  mapper.map(repo.save(admin),AdminRole.class);


    }




}

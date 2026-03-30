package com.SchoolManagementSystem.SchoolManagementSystem;

import com.SchoolManagementSystem.SchoolManagementSystem.Repository.AdminRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.StudRepo;
import com.SchoolManagementSystem.SchoolManagementSystem.Repository.SubjectRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SchoolManagementSystemApplicationTests {

    @Autowired
    SubjectRepo repo;


    @Autowired
    StudRepo studRepo;


    @Autowired
    AdminRepo adminRepo;


	@Test
	void contextLoads() {


//        List<Employee> rangeemployee=employeeRepository.findByrange(20000,30000);
//
//        System.out.println(rangeemployee);

//
//        List<Employee> employees = employeeRepository.findindept("HR", "IT");

//System.out.println(employees);


//        List<String> empp= employeeRepository.findDistinct();
//System.out.println(empp);

//
//List<Employee> empp=employeeRepository.Sortitem("salary");
//
//System.out.println(empp);


//        List<Employee> list=employeeRepository.firstnamelike("ar");
//
//
//System.out.println(list);

//
//        List<Object[]>list=employeeRepository.findbyunique();
//
//        List<String> result =
//                employeeRepository.findbyunique()
//                        .stream()
//                        .map(row -> {
//                            return row[0] + " - " + row[1]+ " - "+ row[2];
//                        })
//                        .toList();
//
//
//        System.out.println(result);
//        int sum=employeeRepository.sumtotalsalary();
//
//        int max=employeeRepository.maxisalary();
//
//        int countmember=employeeRepository.counting();
//
//        System.out.println(sum + " "+ max + " "+ countmember);
//


//
//        List<Object[]> employee=employeeRepository.findlowestthree();
//
//
//
//        List<String>list=employee.stream()
//                             .map(
//                                     objects ->  objects[0] + "  " + objects[1]
//                             ).toList();
//
//        System.out.println(list);

//        List<Object[]> emp=employeeRepository.findbyavarage();
//        List<String>list=emp.stream()
//                .map(
//                        objects ->  objects[0] + "  " + objects[1]
//                ).toList();
//
//        System.out.println(list);
//System.out.println(employeeRepository.findbyavarage());


//        List<AdminEntity> adminEntityList=adminRepo.alllget();
//
//
//        System.out.println(adminEntityList);



//List<SubjectEntity> list=repo.getallS();
//System.out.println(list);






        //        int update=repo.updateData("c++", 3L);
//System.out.println(update);

//        int delete =repo.deleterow(3L);





//        List<SubjectEntity> sub=repo.findAllSub();
//
//
//        System.out.println(sub);
////
//        String allname=repo.findByid(2L);
//
//        System.out.println(allname);

    }




}

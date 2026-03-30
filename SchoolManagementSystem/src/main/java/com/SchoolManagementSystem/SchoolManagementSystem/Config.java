package com.SchoolManagementSystem.SchoolManagementSystem;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {



    @Bean
    ModelMapper getModelMapper(){
        return new ModelMapper();
    }





}

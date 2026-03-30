package com.SchoolManagementSystem.SchoolManagementSystem.advice;

import jdk.dynalink.linker.LinkerServices;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ApiError {

    HttpStatus status;
    String ErrorMessage;
    List<String> SubErrorMessage;


}

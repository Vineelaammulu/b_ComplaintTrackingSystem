package org.cts.app.controller;

import org.cts.app.dto.StudentInfoDto;
import org.cts.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);


    @PostMapping("/register")
    public ResponseEntity<?> registerStudentDetails(@RequestBody StudentInfoDto studentInfoDto){
        logger.info("Entered into Student register controller");
        return studentService.saveStudentInfo(studentInfoDto);
    }

    @GetMapping("login/getDetails")
    public ResponseEntity<?> getStudentDetails(@RequestParam String regId,
                                               @RequestParam String password){
        logger.info("Entered into student longin controller");
        return studentService.getStudentLoginDetails(regId,password);
    }
}

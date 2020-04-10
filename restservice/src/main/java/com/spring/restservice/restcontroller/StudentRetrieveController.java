package com.spring.restservice.restcontroller;


import com.spring.restservice.model.Student;
import com.spring.restservice.model.StudentRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentRetrieveController {

    @GetMapping("/student/allstudent")
    @ResponseBody
    public List<Student> getAllStudents() {
        return StudentRegistration.getInstance().getStudentRecords();
    }
}

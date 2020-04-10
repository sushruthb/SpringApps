package com.spring.restservice.restcontroller;


import com.spring.restservice.model.Student;
import com.spring.restservice.model.StudentRegistration;
import com.spring.restservice.model.StudentRegistrationReply;
import org.springframework.web.bind.annotation.*;

public class StudentRegistrationController {

    //@PostMapping("/register/student")
    @RequestMapping(method = RequestMethod.POST, value="/register/student")
    @ResponseBody
    public StudentRegistrationReply registerStudent(@RequestBody Student student) {
        System.out.println("In registerStudent");
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();
        StudentRegistration.getInstance().add(student);
        //We are setting the below value just to reply a message back to the caller
        stdregreply.setName(student.getName());
        stdregreply.setAge(student.getAge());
        stdregreply.setRegistrationNumber(student.getRegistrationNumber());
        stdregreply.setRegistrationStatus("Successful");
        return stdregreply;
    }
}

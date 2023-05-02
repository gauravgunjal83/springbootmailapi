package com.csi.controller;

import com.csi.model.EmployeeModel;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/mail")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/sendemail")

    public ResponseEntity<String> sendEmail(@RequestBody EmployeeModel employeeModel) throws MessagingException {
        employeeServiceImpl.sendEmail(employeeModel);

        return ResponseEntity.ok("Email sent Successfully");
    }
}

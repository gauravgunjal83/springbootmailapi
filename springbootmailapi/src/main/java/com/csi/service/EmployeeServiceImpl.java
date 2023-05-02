package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public void sendEmail(EmployeeModel employeeModel) throws MessagingException {
        employeeDaoImpl.sendEmail(employeeModel);
    }
}

package com.csi.dao;

import com.csi.model.EmployeeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
@Slf4j
public class EmployeeDaoImpl {



    @Autowired
    private JavaMailSender mailSender;

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() throws MessagingException {

    }
    public void sendEmail(EmployeeModel employeeModel) throws MessagingException {

        log.info("*************TO EMAIL*********"+ employeeModel.getToEmail());

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("gauravgunjal83@gmail.com");
        mimeMessageHelper.setTo(employeeModel.getToEmail());
        mimeMessageHelper.setCc(employeeModel.getCcEmail());

        mimeMessageHelper.setText(employeeModel.getEmailBody());
        mimeMessageHelper.setSubject(employeeModel.getEmailSubject());

        FileSystemResource fileSystem
                = new FileSystemResource(new File(employeeModel.getEmailAttachment()));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),
                fileSystem);

        mailSender.send(mimeMessage);
        log.info("Mail Send...Good");

    }
}

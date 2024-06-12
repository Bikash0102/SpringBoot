package com.example.demo.Employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service
public class Empservice {



    @Autowired 
    JdbcTemplate jdbc;

    public int adddata(Pojo p)
    {
       String name=p.getName();
     String lastname=p.getLastname();
     String department=p.getDepartment();
    int phonenumber=p.getPhonenumber();
      String gmail=p.getGmail();
     String worklocation=p.getWorklocation(); 
   String pincode=p.getPincode();
     double salary=p.getSalary();
     String workmail="";
     workmail=name.substring(0,1).toLowerCase()+lastname.toLowerCase()+"@miraclesoft.com";
     LocalDateTime now = LocalDateTime.now();

        // Define the format for hours and minutes
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        // Define the format for the date
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the current time and date
        String currentTime = now.format(timeFormatter);
        String currentDate = now.format(dateFormatter);
     String password="";
     password=lastname.substring(lastname.length() - 2)+"#"+name.substring(0, 2)+currentTime;
  
     String sql ="Insert into Employe  values(?,?,?,?,?,?,?,?,?,?,?,?)";
     int i=jdbc.update(sql,0,name,lastname,department,phonenumber,currentDate, gmail,workmail,password,worklocation,pincode,salary);
     return i;

    }
    
}

    
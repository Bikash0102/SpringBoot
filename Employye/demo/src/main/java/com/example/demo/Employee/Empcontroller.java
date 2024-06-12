package com.example.demo.Employee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
  
@RestController
@RequestMapping("/employee")
public class Empcontroller {
  

      @Autowired 
   Empservice ps;

    @PostMapping("/insert")
    public Map addProduct(@RequestBody Pojo p) {

        HashMap<String, String> hs = new HashMap<String, String>();
        int add = ps.adddata(p);
        if (add > 0) {
            hs.put("S", "data inserted");
        } else {
            hs.put("N", "data not inserted");
        }
        return hs;

    }

}



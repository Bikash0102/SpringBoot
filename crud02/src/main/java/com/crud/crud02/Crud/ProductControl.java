package com.crud.crud02.Crud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")

public class ProductControl {
    @Autowired 
    ProductService ps;
     @PostMapping("/i_pro")
    public Map addProduct(@RequestBody Product p){
        
        HashMap<String,String> hs = new HashMap<String, String>();
        int add = ps.addProduct(p);
        if(add>0){
            hs.put("S", "data inserted");
        }
        else{
            hs.put("N", "data not inserted");
        }
        return hs;

    } 
    @PostMapping("/update")
    public Map  updateProduct(@RequestBody Product p){
        
        HashMap<String,String> hs = new HashMap<String, String>();
        int sum = ps.updateProduct(p);
        if(sum>0){
            hs.put("S", "data updated");
        }
        else{
            hs.put("N", "data not updated");
        }
        return hs;
    } 
    @PostMapping("/delete")
    public Map  deleteProduct(@RequestBody Product p){
        
        HashMap<String,String> hs = new HashMap<String, String>();
        int sum = ps.deleteProduct(p);
        if(sum>0){
            hs.put("S", "data Deleted");
        }
        else{
            hs.put("N", "data not Deleted");
        }
        return hs;
    } 
     
    @GetMapping("/all")
    public List getAllProducts() {
        return ps.getAllProducts();
    }
    @GetMapping("/getbyid")
    public List getDatabyID(@RequestBody Product p)
    {
        return ps.getDatabyID(p);
    }
     
    @GetMapping("/getbyidname")
    public List getDatabyIDname(@RequestBody Product p)
    {
        return ps.getDatabyIDname(p);
    }
         
    @GetMapping("/searchProducts")
    public List searchProducts(@RequestBody Product p)
    {
        return ps.searchProducts(p);
    }





    
}

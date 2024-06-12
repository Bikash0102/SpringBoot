package com.crud.crud02.Crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired 
    JdbcTemplate jdbc;

    public int addProduct(Product p)
    {
        int id =p.getId();
        String name =p.getName();
        String  type =p.getType();
        double price=p.getPrice();
        String sql ="Insert into Product values(?,?,?,?)";
        int i=jdbc.update(sql, id,name,type,price);
        return i;


    }
    public int updateProduct(Product p)
    {
        int id =p.getId();
        double price=p.getPrice();
        String sql ="update Product set price =? where id=?";
        int i=jdbc.update(sql,price,id);
        return i;
    }
    
    public int deleteProduct(Product p)
    {


        int id=p.getId();
        String sql="delete from Product where id =?";
        int i=jdbc.update(sql,id);
        return i;

    }
      public List<Map<String,Object>> getAllProducts() {
        String sql = "SELECT * FROM Product";
        List<Map<String, Object>> products = jdbc.queryForList(sql);
        return replaceKeysWithHardcodedKeys(products);
    }
    private List<Map<String, Object>> replaceKeysWithHardcodedKeys(List<Map<String, Object>> list) {

        Map<String, String> keyMapping = new HashMap<>();
        keyMapping.put("id", "productId");
        keyMapping.put( "productName","name");
        keyMapping.put( "producttype","type");
        keyMapping.put("price", "productPrice");
        // Add other column mappings as needed

        List<Map<String, Object>> modifiedList = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Map<String, Object> modifiedMap = new HashMap<>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String originalKey = entry.getKey().toLowerCase(); // Ensure the original key is in lowercase
                String hardcodedKey = keyMapping.getOrDefault(originalKey, originalKey);
                modifiedMap.put(hardcodedKey, entry.getValue());
            }
            modifiedList.add(modifiedMap);
        }
        return modifiedList;
    }
    public List<Map<String,Object>> getDatabyID(Product p) {
        int id=p.getId();
        String sql="select * from Product where id =?";
        return jdbc.queryForList(sql,id);
          
        
    }
    public List<Map<String,Object>> getDatabyIDname(Product p) {
        int id=p.getId();
        String name=p.getName();
        String sql="select * from Product where id =? and productname=?";
        return jdbc.queryForList(sql,id,name);
          
        
    }

    public List<Map<String, Object>> searchProducts(Product p) {
        int id=p.getId();
        String name=p.getName();
        String type=p.getType();
        String sql = "SELECT * FROM Product WHERE 1=1" ;
        if(type != null && id!=0)
        {
            sql=sql+" and id = "+id ;
        }
        if(type != null &&!name.equals(""))
        {
            sql=sql+" and productname ='"+name+"'";
        }
        if(type != null && !type.equals(""))
        {
            sql=sql+" and producttype = '"+type+"'";
        }
        return jdbc.queryForList(sql);
    }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    

    
}

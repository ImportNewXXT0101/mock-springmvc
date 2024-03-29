package com.xxt.mockmvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xxt.mockmvc.annotation.MockController;
import com.xxt.mockmvc.annotation.MockQualifier;
import com.xxt.mockmvc.annotation.MockRequestMapping;
import com.xxt.mockmvc.annotation.MockRequestParam;
import com.xxt.mockmvc.service.MyService;

@MockController
@MockRequestMapping("/james")
public class MyController {
    
    @MockQualifier("MyServiceImpl")
    private MyService myService;
    
    @MockRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
            @MockRequestParam("name") String name,
            @MockRequestParam("age") String age) {
        
        try {
            PrintWriter pw = response.getWriter();
            String result = myService.query(name,age);
            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @MockRequestMapping("/insert")
    public void insert(HttpServletRequest request,
            HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            String result = myService.insert("0000");
            
            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @MockRequestMapping("/update")
    public void update(HttpServletRequest request,
            HttpServletResponse response, String param) {
        try {
            PrintWriter pw = response.getWriter();
            String result = myService.update(param);
            
            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

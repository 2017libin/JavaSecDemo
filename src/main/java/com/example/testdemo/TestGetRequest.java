package com.example.testdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author libin
 * @Date 2023/6/10
 */
@RestController
public class TestGetRequest {
    @RequestMapping("/hack")
    public String test(HttpServletRequest request){
        try {
            String data = request.getParameter("data");
            System.out.println(data);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}

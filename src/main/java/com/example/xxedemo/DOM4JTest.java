package com.example.xxedemo;

import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.StringReader;

/**
 * 编号7089
 */
@RestController
public class DOM4JTest {

    @RequestMapping("/dom4jdemo/vul")
    public String dom4jDemo(HttpServletRequest request) {
        try {
            //获取输入流
            InputStream in = request.getInputStream();
            String body =  convertStreamToString(in);

            SAXReader reader = new SAXReader();
            reader.read(new InputSource(new StringReader(body)));
            return "DOM4J XXE......";
        } catch (Exception e) {
            return "EXCEPT ERROR!!!";
        }
    }
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}

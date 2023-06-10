package com.example.xxedemo;

import org.apache.commons.digester.Digester;
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
public class DigesterTest {

    @RequestMapping("/digesterdemo/vul")
    public String digesterDemo(HttpServletRequest request) {
        try {
            //获取输入流
            InputStream in = request.getInputStream();
            String body =  convertStreamToString(in);

            Digester digester = new Digester();
            digester.parse(new StringReader(body));

            return "Digester XXE......";
        } catch (Exception e) {
            return "EXCEPT ERROR!!!";
        }
    }
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}

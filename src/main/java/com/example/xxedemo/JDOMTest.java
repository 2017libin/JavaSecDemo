package com.example.xxedemo;

import org.jdom.input.SAXBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.InputSource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * 编号7089
 */
@RestController
public class JDOMTest {

    @RequestMapping("/jdomdemo/vul")
    public String jdomDemo(HttpServletRequest request) throws IOException {

        //获取输入流
        InputStream in = request.getInputStream();
        String body =  convertStreamToString(in);

        try {
            SAXBuilder builder = new SAXBuilder();
            builder.build(new InputSource(new StringReader(body)));
            return "jdom xxe vuln code";
        } catch (Exception e) {
            return "Error......";
        }

    }
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}

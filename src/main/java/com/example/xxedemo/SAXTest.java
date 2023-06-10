package com.example.xxedemo;

import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * 编号7089
 */
@RestController
public class SAXTest {
    @RequestMapping("/saxdemo/vul")
    public String saxDemo(HttpServletRequest request) throws IOException {

        //获取输入流
        InputStream in = request.getInputStream();
        String body =  convertStreamToString(in);
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            SAXParserHandler handler = new SAXParserHandler();
            //解析xml
            parser.parse(new InputSource(new StringReader(body)), handler);

            return "Sax xxe vuln code";
        } catch (Exception e) {
            return "Error......";
        }
    }
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}

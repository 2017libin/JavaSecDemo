package com.example.xxedemo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.StringReader;

/**
 * 编号7089
 */
@RestController
public class DOMTest {
    @RequestMapping("/domdemo/vul")
    public String domDemo(HttpServletRequest request){
        try {
            //获取输入流
            InputStream in = request.getInputStream();
            String body =  convertStreamToString(in);
            StringReader sr = new StringReader(body);
            InputSource is = new InputSource(sr);
            System.out.println(is);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(is);
            // 遍历xml节点name和value
            StringBuilder buf = new StringBuilder();
            NodeList rootNodeList = document.getChildNodes();
            for (int i = 0; i < rootNodeList.getLength(); i++) {
                Node rootNode = rootNodeList.item(i);
                NodeList child = rootNode.getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    buf.append(String.format("%s: %s\n", node.getNodeName(), node.getTextContent()));
                }
            }
            sr.close();
            return buf.toString();
        } catch (Exception e) {
            return "EXCEPT ERROR!!!";
        }
    }
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}

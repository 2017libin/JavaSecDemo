package com.example.testdemo;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class TestParseXML {
    public static void domDemo() {
        try {
            // 加载XML文件
            ClassPathResource resource = new ClassPathResource("test.xml");
            InputStream inputStream = resource.getInputStream();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(inputStream));

            // 解析内容并输出
//            Element root = document.getDocumentElement();
//            NodeList childNodes = root.getChildNodes();
//            for (int i = 0; i < childNodes.getLength(); i++) {
//                if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
//                    Element childElement = (Element) childNodes.item(i);
//                    // 读取元素内容
//                    String tagName = childElement.getTagName();
//                    String textContent = childElement.getTextContent();
//                    System.out.println(tagName + ": " + textContent);
//                }
//            }
            NodeList rootNodeList = document.getChildNodes();
            for (int i = 0; i < rootNodeList.getLength(); i++) {
                Node rootNode = rootNodeList.item(i);
                NodeList child = rootNode.getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    Node node = child.item(j);
                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        System.out.println(String.format("%s: %s", node.getNodeName(), node.getTextContent()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        domDemo();
    }
}

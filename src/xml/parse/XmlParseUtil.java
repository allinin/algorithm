package xml.parse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlParseUtil {
    //输入一个xml文件的路径名，得到一个List<>
    public List<Dog> parseXmlToList(String fileName) throws Exception {
        //Dom方式解析：入口
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //准备输入流，为parse()做准备
        //解析为可以用java处理的document对象
        Document document = builder.parse(new FileInputStream(fileName));
        Element element = document.getDocumentElement();//获取文当的结点
        NodeList nodeList = element.getElementsByTagName("dog");//获取dog结点
        List<Dog> dogs=new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            //获取每一个dog
            Element dogElement = (Element)nodeList.item(i);
            //获取dog的id属性
            Dog dog=new Dog();
            int id = Integer.parseInt(dogElement.getAttribute("id"));

            dog.setId(id);
            //获取dog的子节点
            NodeList childNodes = dogElement.getChildNodes();
            for(int j=0;j<childNodes.getLength();j++)
            {
                Node item = childNodes.item(j);
                //只拿<zxx>形式的子节点
                if(item.getNodeType()==Node.ELEMENT_NODE) {
                    if (item.getNodeName().equals("name")) {
                        String name = item.getFirstChild().getNodeValue();
                        dog.setName(name);
                    } else if (item.getNodeName().equals("score")) {
                        int score = Integer.parseInt(item.getFirstChild().getNodeValue());
                        dog.setScore(score);
                    } else {
                        int level = Integer.parseInt(item.getFirstChild().getNodeValue());
                        dog.setLevel(level);
                    }
                }
            }
          dogs.add(dog);
        }
        return dogs;
    }
}

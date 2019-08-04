package xml.parse;

import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        XmlParseUtil xmlParseUtil=new XmlParseUtil();
        List<Dog> dogs = xmlParseUtil.parseXmlToList("src/xml/parse/dogs.xml");
        System.out.println(dogs);


    }
}

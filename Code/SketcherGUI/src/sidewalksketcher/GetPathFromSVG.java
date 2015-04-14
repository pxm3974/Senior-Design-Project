package sidewalksketcher;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetPathFromSVG {

    public static void main(String args[]) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        builder = factory.newDocumentBuilder();
        String path= System.getProperty("user.dir");
        String FileName= path+ "/potrace/Image.svg";
        Document document = builder.parse(FileName);

        String xpathExpression = "//path/@d";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile(xpathExpression);
        NodeList svgPaths = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        int noOfPath = svgPaths.getLength();
        for (int i = 0; i <= noOfPath; i++) {

            if (svgPaths.item(i) != null) {
                System.out.println(svgPaths.item(i).getNodeValue());
            }

        }

    }
}

/*
 * Class: GetPathFromSVG
 * Method: Path()
 * Description: Gets the path of the vector image.
 */
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

/**
 *
 * @author unknown
 * Source: StackOverFlow
 * Modification: Sabin Raj Bajracharya
 */
public class GetPathFromSVG {

    public void path() throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {

        FileInput myPath = new FileInput();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        builder = factory.newDocumentBuilder();
        String path = System.getProperty("user.dir");
        String FileName = path + "/potrace/Image.svg";
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
                myPath.path(svgPaths.item(i).getNodeValue());

            }

        }

    }
}

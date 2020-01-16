package by.select.stage5.main;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXml implements Read {

	public static void main(String[] args) {
		ReadXml readXml = new ReadXml();
		readXml.read();
	}

	public void read() {
		try {

			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document document = documentBuilder.parse(
					"C:\\Users\\Aliaksandr_Dabarovic\\eclipse-workspace\\pre-selection_2_4\\src\\by\\select\\stage5\\main\\read.xml");

			Node root = document.getDocumentElement();

			System.out.println("List of flowers:");
			System.out.println();

			NodeList flowers = root.getChildNodes();
			for (int i = 0; i < flowers.getLength(); i++) {
				Node flower = flowers.item(i);

				if (flower.getNodeType() != Node.TEXT_NODE) {
					NodeList flowerProps = flower.getChildNodes();
					for (int j = 0; j < flowerProps.getLength(); j++) {
						Node flowerProp = flowerProps.item(j);

						if (flowerProp.getNodeType() != Node.TEXT_NODE) {
							System.out.println(flowerProp.getNodeName() + ":"
									+ flowerProp.getChildNodes().item(0).getTextContent());
						}
					}
					System.out.println("===========>>>>");
				}
			}

		} catch (ParserConfigurationException ex) {
			ex.printStackTrace(System.out);
		} catch (SAXException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
	}
}

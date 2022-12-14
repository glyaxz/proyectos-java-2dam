package ejerciciosT1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Ejercicio10 {
	public static void main(String[] args) {
		String xmlFile = "FichPers.xml";
		String xslFile = "FichPers.xsl";
		File xmlToHTML = new File("FichPers.html");
		try {
			FileOutputStream os = new FileOutputStream(xmlToHTML);
			
			Source styles = new StreamSource(xslFile);
			Source data = new StreamSource(xmlFile);
			Result result = new StreamResult(os);
			
			Transformer tr = TransformerFactory
					.newInstance()
					.newTransformer(styles);
			tr.transform(data, result);
			System.out.println("WORKED");
			os.close();
			
		}catch(TransformerException|FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException f) {
			f.printStackTrace();
		}
		
	}
}

package creacionPersonas;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;


public class Ejercicio8 {
	public static void main(String[] args) {
		try {
			File f = new File("/home/glyaxz/Escritorio/Testing/departamentos.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			
			int id, deps;
			int position = 0, intAux;
			char[] nombre = new char[10],
					localidad = new char[10];
			char aux;
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Departamentos", null);
			document.setXmlVersion("1.0");
			
			for(;;) {
				//id->nombre->localidad->deps
				raf.seek(position);
				id = raf.readInt();
				for(int i = 0; i < nombre.length; i++) {
					aux = raf.readChar();
					nombre[i] = aux;
				}
				
				String finalNombre = new String(nombre);
				for(int i = 0; i < localidad.length; i++) {
					aux = raf.readChar();
					localidad[i] = aux;
				}
				
				String finalLocalidad = new String(localidad);
				deps = raf.readInt();
				position+=48;
				
				if(id > 0) {
					Element raiz = document.createElement("Departamento");
					document.getDocumentElement().appendChild(raiz);

					CreateElement("id", Integer.toString(id), raiz, document);
					CreateElement("nombre", finalNombre.trim(), raiz, document);
					CreateElement("localidad", finalLocalidad.trim(), raiz, document);
					CreateElement("deps", Integer.toString(deps), raiz, document);
					
				}
				if(raf.getFilePointer() == raf.length()) {
					break;
				}
				
			}
			
			Source source = new DOMSource(document);
			Result result = new StreamResult(new java.io.File("/home/glyaxz/Escritorio/Testing/departamentos.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
			raf.close();
			
		}catch(EOFException g){
			g.printStackTrace();
		}catch (TransformerException|ParserConfigurationException|IOException e) {
			System.err.println(e.getLocalizedMessage());
		}catch (ArrayIndexOutOfBoundsException f) {
			//No quiero que haga nada
		}
	}
	
	static void CreateElement(String datoDepart, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoDepart);
		Text text = document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}	
	
	static void CreateElement(String datoDepart, int valor, Element raiz, Document document) {
		Element elem = document.createElement(datoDepart);
		Text text = document.createTextNode(Integer.toString(valor));
		raiz.appendChild(elem);
		elem.appendChild(text);
	}
}

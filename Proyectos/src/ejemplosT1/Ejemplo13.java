package ejemplosT1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.*;

/*
 * A partir del fichero de objetos Persona utilizado anteriormente, crea un documento XML
 * usando DOM 
*/

public class Ejemplo13 {
	public static void main(String[] args) {
		try {
			File file = new File("/home/glyaxz/Escritorio/Testing/xmlData.dat");
			Persona p1 = new Persona("Javier","Garcia Ruiz", "12345678A", 19);
			
			RandomAccessFile raf = new RandomAccessFile(file, "rw");			
			
		}catch(IOException  e) {
			System.out.println(e.getMessage());
		}
	}
}

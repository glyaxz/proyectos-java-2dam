package ejemplosT1;
import java.io.*;


public class Ejemplo2 {
	public static void main(String[] args) {
		String directory = "/db";
		File f = new File(directory);
		String[] list = f.list();
		System.out.println("Ficheros dentro del directorio "+directory+": "+list.length);
		for(int i = 0; i < list.length; i++) {
			File f2 = new File(f, list[i]);
			System.out.printf("Nombre: %s, ¿Es fichero?: %b, ¿Es directorio?: %b %n", list[i], f2.isFile(), f2.isDirectory());
		}
	}
}

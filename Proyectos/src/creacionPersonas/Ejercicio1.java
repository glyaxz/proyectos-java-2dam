package creacionPersonas;
import java.io.*;

public class Ejercicio1 {
	public static void main(String[] args) {
		String dir = args[0];
		File f = new File(dir);
		
		if(f.isDirectory()) {
			File[] listFiles = f.listFiles();
			if(listFiles.length == 0) {
				try {
					System.out.println("Eliminando el directorio "+f.getName());
					f.delete();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println("El directorio introducido no está vacio, contiene "+f.listFiles().length+" ficheros, eliminando ficheros del directorio");
				for(int i = 0; i < f.listFiles().length; i++) {
					try {
						System.out.println("Eliminando el fichero "+listFiles[i].getName());
						listFiles[i].delete();
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}else {
			System.out.println("El valor introducido no es válido");
		}
	}
}


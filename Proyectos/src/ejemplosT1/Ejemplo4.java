package ejemplosT1;
import java.io.*;

public class Ejemplo4 {
	public static void main(String[] args) {
		String dir = args[0];
		File f = new File(dir);
		if(f.isDirectory()) {
			File[] list = f.listFiles();
			for(int i = 0; i < list.length; i++) {
				System.out.println("Nombre del fichero			:"+list[i].getName());
				System.out.println("Ruta absoluta				:"+list[i].getPath());
				System.out.println("Ruta relativa				:"+list[i].getAbsolutePath());
				System.out.println("Se puede leer				:"+list[i].canRead());
				System.out.println("Se puede escribir			:"+list[i].canWrite());
				System.out.println("Tamaño					:"+list[i].length());
				System.out.print("Fichero o directorio			:");
				if(list[i].isDirectory()) {
					System.out.println("Directorio");
				}else {
					System.out.println("Fichero");
				}
				System.out.println("Nombre del directorio padre		:"+list[i].getParent());
				System.out.println("------------------------------------------------------------------------");
			}
		}else {
			System.out.println("El valor introducido no es un directorio");
		}

		
	}
}

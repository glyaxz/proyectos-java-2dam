package ejerciciosT1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Realiza un programa en Java que te permita eliminar un departamento. El
 * programa recibe desde la línea de comandos el número de departamento a eliminar.
 * Si el departamento no existe, visualiza un mensaje indicándolo. Visualiza también el
 * número total de departamentos que existen en el fichero
 */

public class Ejercicio6 {
	public static void main(String[] args) {
		File file = new File("/home/glyaxz/Escritorio/Testing/randomFile.dat");
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			//Orden: id->nombre->localidad->deps
			int dept_A_Eliminar = Integer.parseInt(args[0]);
			
			long position = (dept_A_Eliminar - 1) * 48;
			raf.seek(position);
			raf.write(null);
			position += 4;
			raf.seek(position);
			raf.writeChars(null);
			position += 20;
			raf.seek(position);
			raf.writeChars(null);
			position += 4;
			raf.seek(position);
			raf.write(null);
			
			raf.close();
						
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

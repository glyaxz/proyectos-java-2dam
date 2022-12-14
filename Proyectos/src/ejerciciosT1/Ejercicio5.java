package ejerciciosT1;
import java.io.*;

/*
 * Realiza un programa en Java que te permita modificar los datos de un departamento.
 * El programa recibe desde la línea de comandos el número de departamento a
 * modificar, el nuevo nombre de departamento y la nueva localidad. Si el departamento
 * no existe visualiza un mensaje indicándolo. Visualiza también los datos antiguos del
 * departamento y los nuevos datos.
 */

public class Ejercicio5 {
	public static void main(String[] args){
		File file = new File("randomFile.dat");
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			StringBuffer buffer = null;
			int registro = Integer.parseInt(args[0]);
			
			long position = (registro - 1) * 48;
			position = position+4+20;
			raf.seek(position);
			raf.writeChars(args[1]);
			position += 20;
			raf.writeChars(args[2]);
			raf.close();
						
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

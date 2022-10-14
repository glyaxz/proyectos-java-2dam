package ejerciciosT1;
import java.io.*;

/*
 * Realiza un programa en Java que cree un fichero aleatorio para guardar datos de
 * departamentos, dale el nombre Departamentos.dat. Introduce varios departamentos.
 * Los datos por cada departamento son: Número de departamento: entero, Nombre:
 * String y Localidad: String.
*/


public class Ejercicio4 {
	public static void main(String[] args) {
		File f1 = new File("departamentos.dat");
		try {
			RandomAccessFile raf = new RandomAccessFile(f1, "rw");
			int[] id = {
				10,
				20,
				30,
				40,
				50
			};
			
			int[] deps = {
				456,
				234,
				454,
				765,
				321
			};
			
			String[] nombre = {
				"Apart1",
				"Apart2",
				"Apart3",
				"Apart4",
				"Apart5",
			},
			
			localidad = {
				"Granada",
				"Jaen",
				"Madrid",
				"Granada",
				"Sevilla"
			};
			
			StringBuffer buffer = null;
			for(int i = 0; i < localidad.length; i++) {
				//Orden: id->nombre->localidad->deps
				long position = (id[i] - 1) * 48;
				raf.seek(position);
				raf.writeInt(id[i]);
				buffer = new StringBuffer(nombre[i]);
				buffer.setLength(10);
				raf.writeChars(buffer.toString());
				buffer = new StringBuffer(localidad[i]);
				buffer.setLength(10);
				raf.writeChars(buffer.toString());
				raf.writeInt(deps[i]);
			}
			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

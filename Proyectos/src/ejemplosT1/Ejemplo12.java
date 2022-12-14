package ejemplosT1;
import java.io.*;

public class Ejemplo12 {
	public static void main(String[] args) {
		File file = new File("/home/glyaxz/Escritorio/Testing/randomFile.dat");
		try {
			//Escritura
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			StringBuffer buffer = null;
			String[] apellido = {
					"fernandez",
					"ruiz",
					"garcia",
					"jurado",
					"gonzalez"
			};
			
			double[] salario = {
					1230.99,
					3647.88,
					1099.33,
					908.32,
					1789.78
			};
			
			int[] dep = {
					10,
					20,
					30,
					30,
					10
			};
			
			int[] id = {
					20,
					21,
					22,
					23,
					24
			};
			
			for(int i = 0; i < dep.length; i++) {
				long position = (id[i] - 1) * 36;
				raf.seek(position);
				raf.writeInt(id[i]);
				buffer = new StringBuffer(apellido[i]);
				buffer.setLength(10);
				raf.writeChars(buffer.toString());
				raf.writeInt(dep[i]);
				raf.writeDouble(salario[i]);
			}
			
			//Lectura
			int rId = Integer.parseInt(args[0]);
			int position = (rId - 1) * 36;
			if(rId >= raf.length()) {
				System.out.println("Identificador no encontrado");
			}else {
				raf.seek(position);
				rId = raf.readInt();
				System.out.println("testing");
			}
			
			raf.close();
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

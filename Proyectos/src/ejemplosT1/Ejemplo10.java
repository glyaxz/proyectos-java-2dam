package ejemplosT1;
import java.io.*;

public class Ejemplo10 {
	public static void main(String[] args) {
		try {
			File fichero = new File("/home/glyaxz/Escritorio/FichData.dat");
			DataOutputStream dataOS = new DataOutputStream(new FileOutputStream(fichero));
			
			String[] nombres = {
					"ana",
					"luis miguel",
					"alicia",
					"julian",
					"jose miguel",
					"roberto",
					"javi",
					"sergio",
					"pedro"
			};
			
			int[] edades = {
					14,
					15,
					16,
					17,
					18,
					19,
					20,
					21,
					22
			};
			
			for(int i = 0; i < edades.length; i++) {
				dataOS.writeUTF(nombres[i]);
				dataOS.writeInt(edades[i]);
			}
			dataOS.close();
			
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException f) {
			System.out.println(f.getMessage());
		}
	}
}

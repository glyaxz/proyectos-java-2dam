package ejemplosT1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class Ejemplo11 {
	public static void main(String[] args) {
		try {
			File fichero = new File("/home/glyaxz/Escritorio/FichData.dat");
			DataInputStream dataIS = new DataInputStream(new FileInputStream(fichero));
			String n;
			int e;
			boolean can_continue = true;
			
			while(can_continue) {
				n = dataIS.readUTF();
				e = dataIS.readInt();
				if(n != null) {
					System.out.println("Nombre: " + n + ", edad: " + e);
				}else{
					can_continue = false;
				}
			}
			
			dataIS.close();
			
		}catch(EOFException e) {
			System.out.println(e.getMessage());
		}catch(IOException f) {
			System.out.println(f.getMessage());
		}
	}
}

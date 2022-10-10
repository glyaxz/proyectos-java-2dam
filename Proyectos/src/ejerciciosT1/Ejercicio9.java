package ejerciciosT1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

public class Ejercicio9 {

	public static void main(String[] args) {
		try{
			File f = new File("/home/glyaxz/Escritorio/Testing/dbPersona.dat");
			ObjectInputStream dataIS4 = new ObjectInputStream(new FileInputStream(f));
			
			ListPersona lp = new ListPersona();
			
			try {
				while(true) {
					Persona persona = (Persona) dataIS4.readObject();
					lp.add(persona);
				}
			}catch(EOFException e) {
				e.printStackTrace();
			}
			dataIS4.close();
			try {
				System.out.println("debug");
				XStream xs = new XStream();
				xs.alias("ListaPersonasMunicipio", ListPersona.class);
				xs.alias("DatosPersona", Persona.class);
				
				xs.toXML(lp, new FileOutputStream("/home/glyaxz/Escritorio/Testing/FichPers.xml"));
				System.out.println("Fichero exportado.");
				
			}catch(Exception p){
				p.printStackTrace();
			}
			
			
		}catch (ClassNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}

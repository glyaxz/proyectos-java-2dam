package creacionPersonas;

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
			File f = new File("/home/glyaxz/Escritorio/Testing/dbAlumno.dat");
			ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(f));
			
			ListPersona lp = new ListPersona();
			
			try {
				while(true) {
					Alumno persona = (Alumno) dataIS.readObject();
					lp.add(persona);
				}
			}catch(EOFException e) {
				e.printStackTrace();
			}
			dataIS.close();
			
			try {
				XStream xs = new XStream();
				xs.alias("ListaPersonasMunicipio", ListPersona.class);
				xs.alias("DatosPersona", Persona.class);
				
				xs.addImplicitCollection(ListPersona.class, "lista");
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
